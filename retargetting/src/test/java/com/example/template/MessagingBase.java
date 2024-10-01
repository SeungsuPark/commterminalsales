package com.example.template;

import commterminalsales.RetargettingApplication;
import commterminalsales.domain.*;
import commterminalsales.infra.RetargettingController;
import java.util.concurrent.TimeUnit;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.verifier.messaging.MessageVerifier;
import org.springframework.cloud.contract.verifier.messaging.boot.AutoConfigureMessageVerifier;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.MimeTypeUtils;

@RunWith(SpringRunner.class)
@SpringBootTest(
    classes = RetargettingApplication.class,
    webEnvironment = SpringBootTest.WebEnvironment.NONE
)
@AutoConfigureMessageVerifier
public abstract class MessagingBase {

    private Logger logger = LoggerFactory.getLogger(MessagingBase.class);

    @Autowired
    RetargettingController retargettingController;

    @Autowired
    // Message interface to verify Contracts between services.
    MessageVerifier<Message<?>> messaging;

    @Before
    public void setup() {
        // any remaining messages on the "eventTopic" channel are cleared
        // makes that each test starts with a clean slate
        this.messaging.receive("eventTopic", 100, TimeUnit.MILLISECONDS);
    }

    public void discountPolicyActivated() {
        String serializedJson = null;
        Retargetting retargetting = new Retargetting();

        DiscountPolicyActivated discountPolicyActivated = new DiscountPolicyActivated(
            retargetting
        );

        serializedJson = discountPolicyActivated.toJson();

        logger.info("Sending message: {}", serializedJson);
        this.messaging.send(
                MessageBuilder
                    .withPayload(serializedJson)
                    .setHeader(
                        MessageHeaders.CONTENT_TYPE,
                        MimeTypeUtils.APPLICATION_JSON
                    )
                    .build(),
                "eventTopic"
            );
    }
}
