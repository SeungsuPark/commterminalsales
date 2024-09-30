package commterminalsales.domain;

import commterminalsales.domain.*;
import commterminalsales.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class OrderPlaced extends AbstractEvent {

    private Long id;
    private String productId;
    private Object options;
    private String customerId;
    private String address;
    private String insuranceOption;
}
