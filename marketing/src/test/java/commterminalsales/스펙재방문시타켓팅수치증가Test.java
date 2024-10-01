package commterminalsales;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import commterminalsales.config.kafka.KafkaProcessor;
import commterminalsales.domain.*;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.verifier.messaging.MessageVerifier;
import org.springframework.cloud.contract.verifier.messaging.boot.AutoConfigureMessageVerifier;
import org.springframework.cloud.contract.verifier.messaging.internal.ContractVerifierMessage;
import org.springframework.cloud.contract.verifier.messaging.internal.ContractVerifierMessaging;
import org.springframework.cloud.contract.verifier.messaging.internal.ContractVerifierObjectMapper;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.cloud.stream.test.binder.MessageCollector;
import org.springframework.context.ApplicationContext;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.MimeTypeUtils;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMessageVerifier
public class 스펙재방문시타켓팅수치증가Test {

    private static final Logger LOGGER = LoggerFactory.getLogger(
        스펙재방문시타켓팅수치증가Test.class
    );

    @Autowired
    private KafkaProcessor processor;

    @Autowired
    private MessageCollector messageCollector;

    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    private MessageVerifier<Message<?>> messageVerifier;

    @Test
    @SuppressWarnings("unchecked")
    public void test0() {
        //given:

        entity.setId(1L);
        entity.setCustomerId("C001");
        entity.setProductId("P001");
        entity.setReturnCount(2L);

        repository.save(entity);

        //when:

        SpecCompared event = new SpecCompared();

        event.setId(1L);
        event.setCustomerId("C001");
        event.setProductId("P001");
        event.setOptions(new Object[] { "Option A", "Option B" });

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String msg = objectMapper.writeValueAsString(event);

            this.messageVerifier.send(
                    MessageBuilder
                        .withPayload(msg)
                        .setHeader(
                            MessageHeaders.CONTENT_TYPE,
                            MimeTypeUtils.APPLICATION_JSON
                        )
                        .setHeader("type", event.getEventType())
                        .build(),
                    "commterminalsales"
                );

            //then:

            Message<?> receivedMessage =
                this.messageVerifier.receive(
                        "commterminalsales",
                        5000,
                        TimeUnit.MILLISECONDS
                    );

            assertNotNull("Resulted event must be published", receivedMessage);

            DiscountPolicyActivated outputEvent = objectMapper.readValue(
                receivedMessage.getPayload(),
                DiscountPolicyActivated.class
            );

            LOGGER.info("Response received: {}", receivedMessage.getPayload());

            assertEquals(outputEvent.getId(), null);
            assertEquals(outputEvent.getCustomerId(), "C001");
            assertEquals(outputEvent.getProductId(), "P001");
        } catch (JsonProcessingException e) {
            // TODO Auto-generated catch block
            assertTrue("exception", false);
        }
    }
}
