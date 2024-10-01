package contracts.messaging
import org.springframework.cloud.contract.spec.Contract

Contract.make {
    // The Identifier which can be used to identify it later.
    label 'DiscountPolicyActivated'
    input {
        // Contract will be triggered by the following method.
        triggeredBy('discountPolicyActivated()')
    }
    outputMessage {
        sentTo 'eventTopic'
        // Consumer Expected Payload spec. that a JSON message must have, 
        // If the Producer-side test is OK, then send the following msg to event-out channel.
        body(
            eventType: "DiscountPolicyActivated",
        )
        bodyMatchers {
        }
        headers {
            messagingContentType(applicationJson())
        }
    }
}