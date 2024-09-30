package commterminalsales.domain;

import commterminalsales.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class OrderPlaced extends AbstractEvent {

    private Long id;
    private String productId;
    private List<String> options;
    private String customerId;
    private String address;
    private String insuranceOption;
}
