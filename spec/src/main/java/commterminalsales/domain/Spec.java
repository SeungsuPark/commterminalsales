package commterminalsales.domain;

import commterminalsales.SpecApplication;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Spec_table")
@Data
//<<< DDD / Aggregate Root
public class Spec {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String spec;

    private String manufacturer;

    private String phoneColor;

    private String phoneType;

    public static SpecRepository repository() {
        SpecRepository specRepository = SpecApplication.applicationContext.getBean(
            SpecRepository.class
        );
        return specRepository;
    }

    public void register() {
        //implement business logic here:

    }
}
//>>> DDD / Aggregate Root