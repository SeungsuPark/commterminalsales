package commterminalsales.domain;

import commterminalsales.domain.*;
import commterminalsales.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class SpecCompared extends AbstractEvent {

    private Long id;
    private String productId;
    private List<String> options;
    private String customerId;

    public SpecCompared(SpecComparation aggregate) {
        super(aggregate);
    }

    public SpecCompared() {
        super();
    }
}
//>>> DDD / Domain Event
