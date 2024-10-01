package commterminalsales.infra;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import commterminalsales.config.kafka.KafkaProcessor;
import commterminalsales.domain.*;
import javax.naming.NameParser;
import javax.naming.NameParser;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

//<<< Clean Arch / Inbound Adaptor
@Service
@Transactional
public class PolicyHandler {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    MessageRepository messageRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='DiscountPolicyActivated'"
    )
    public void wheneverDiscountPolicyActivated_Alert(
        @Payload DiscountPolicyActivated discountPolicyActivated
    ) {
        DiscountPolicyActivated event = discountPolicyActivated;
        System.out.println(
            "\n\n##### listener Alert : " + discountPolicyActivated + "\n\n"
        );

        // Sample Logic //
        Message.alert(event);
    }
}
//>>> Clean Arch / Inbound Adaptor
