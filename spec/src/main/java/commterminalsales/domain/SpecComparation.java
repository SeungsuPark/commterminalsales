package commterminalsales.domain;

import commterminalsales.SpecApplication;
import commterminalsales.domain.SpecCompared;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "SpecComparation_table")
@Data
//<<< DDD / Aggregate Root
public class SpecComparation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String productId;

    @ElementCollection
    private List<String> options;

    private String customerId;

    @PostPersist
    public void onPostPersist() {
        SpecCompared specCompared = new SpecCompared(this);
        specCompared.publishAfterCommit();
    }

    public static SpecComparationRepository repository() {
        SpecComparationRepository specComparationRepository = SpecApplication.applicationContext.getBean(
            SpecComparationRepository.class
        );
        return specComparationRepository;
    }

    public void 스펙비교저장() {
        //implement business logic here:

        SpecCompared specCompared = new SpecCompared(this);
        specCompared.publishAfterCommit();
    }
}
//>>> DDD / Aggregate Root
