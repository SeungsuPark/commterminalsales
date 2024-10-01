package com.example.template;

import static org.assertj.core.api.Assertions.assertThat;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import commterminalsales.InsuranceSubscriptionApplication;
import commterminalsales.config.kafka.KafkaProcessor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.StubFinder;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties;
import org.springframework.cloud.stream.test.binder.MessageCollector;
import org.springframework.messaging.Message;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(
    classes = InsuranceSubscriptionApplication.class,
    webEnvironment = SpringBootTest.WebEnvironment.NONE
)
@AutoConfigureStubRunner(
    stubsMode = StubRunnerProperties.StubsMode.LOCAL,
    ids = "commterminalsales:order:+:stubs"
)
public class OrderPlacedContractTest {

    @Autowired
    StubFinder stubFinder;

    @Autowired
    private KafkaProcessor processor;

    @Autowired
    // collect messages sent by a Spring Cloud Stream application
    private MessageCollector messageCollector;

    @Test
    public void testOnMessageReceived() {
        // Set Contract Label
        stubFinder.trigger("OrderPlaced");

        Message<String> received = (Message<String>) messageCollector
            .forChannel(processor.outboundTopic())
            .poll();
        System.out.println("<<<<<<< " + received.getPayload() + ">>>>>>");

        DocumentContext parsedJson = JsonPath.parse(received.getPayload());
    }
}
