package commterminalsales.domain;

import commterminalsales.domain.*;
import commterminalsales.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class DiscountPolicyActivated extends AbstractEvent {

    private Long id;
    private String customerId;
    private String productId;
}
