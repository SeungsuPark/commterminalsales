package commterminalsales.domain;

import commterminalsales.domain.*;
import commterminalsales.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class DiscountPolicyActivated extends AbstractEvent {

    private Long id;
    private String customerId;
    private String productId;

    public DiscountPolicyActivated(Retargetting aggregate) {
        super(aggregate);
    }

    public DiscountPolicyActivated() {
        super();
    }
}
//>>> DDD / Domain Event
