package commterminalsales.domain;

import commterminalsales.domain.*;
import commterminalsales.infra.AbstractEvent;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class PaymentCreated extends AbstractEvent {

    private Long id;
    private BigDecimal amount;
    private String product;
    private String customerId;
    private String paymentMethod;

    public PaymentCreated(Payment aggregate) {
        super(aggregate);
    }

    public PaymentCreated() {
        super();
    }
}
//>>> DDD / Domain Event
