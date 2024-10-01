package commterminalsales.domain;

import commterminalsales.PaymentApplication;
import commterminalsales.domain.PaymentCreated;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Payment_table")
@Data
//<<< DDD / Aggregate Root
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Embedded
    private BigDecimal amount;

    private String product;

    private String customerId;

    private String paymentMethod;

    @PostPersist
    public void onPostPersist() {
        PaymentCreated paymentCreated = new PaymentCreated(this);
        paymentCreated.publishAfterCommit();
    }

    public static PaymentRepository repository() {
        PaymentRepository paymentRepository = PaymentApplication.applicationContext.getBean(
            PaymentRepository.class
        );
        return paymentRepository;
    }

    //<<< Clean Arch / Port Method
    public static void pg에결제요청(OrderPlaced orderPlaced) {
        //implement business logic here:

        System.out.println("PG 결재 요청");

        if(Math.random() > 0.6) throw new RuntimeException("PG 연동 실패");
    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
