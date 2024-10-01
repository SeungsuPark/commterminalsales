package commterminalsales.domain;

import commterminalsales.CustomerApplication;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Message_table")
@Data
//<<< DDD / Aggregate Root
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String message;

    private String customerId;

    public static MessageRepository repository() {
        MessageRepository messageRepository = CustomerApplication.applicationContext.getBean(
            MessageRepository.class
        );
        return messageRepository;
    }

    //<<< Clean Arch / Port Method
    public static void alert(DiscountPolicyActivated discountPolicyActivated) {
        //implement business logic here:

        /** Example 1:  new item         */
        Message message = new Message();
        message.setCustomerId(discountPolicyActivated.getCustomerId());
        message.setMessage("할인쿠폰이 발행되었습니다.");
        repository().save(message);

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
