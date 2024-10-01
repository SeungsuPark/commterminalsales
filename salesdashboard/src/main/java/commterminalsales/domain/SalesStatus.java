package commterminalsales.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

//<<< EDA / CQRS
@Entity
@Table(name = "SalesStatus_table")
@Data
public class SalesStatus {

    @Id
    //@GeneratedValue(strategy=GenerationType.AUTO)
    private Long orderId;

    private String productId;
    private Boolean customerGender;
    private String customerRegion;
    private Boolean insurance;
    private String manufacturer;
    private String phoneColor;
}
