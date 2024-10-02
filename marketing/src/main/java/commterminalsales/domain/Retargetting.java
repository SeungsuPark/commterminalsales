package commterminalsales.domain;

import commterminalsales.MarketingApplication;
import commterminalsales.domain.DiscountPolicyActivated;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Retargetting_table")
@Data
public class Retargetting {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String customerId;

    private String productId;

    private Integer returnCount;

    @PostPersist
    public void onPostPersist() {
        DiscountPolicyActivated discountPolicyActivated = new DiscountPolicyActivated(
            this
        );
        discountPolicyActivated.publishAfterCommit();
    }

    public static RetargettingRepository repository() {
        RetargettingRepository retargettingRepository = MarketingApplication.applicationContext.getBean(
            RetargettingRepository.class
        );
        return retargettingRepository;
    }

    public static void 스펙재방문시타켓팅수치증가(SpecCompared specCompared) {
        repository()
            .findByCustomerId(specCompared.getCustomerId())
            .ifPresentOrElse(
                retargetting -> {
                    retargetting.setReturnCount(
                        retargetting.getReturnCount() + 1
                    );
                    repository().save(retargetting);

                    if (retargetting.getReturnCount() > 3) {
                        DiscountPolicyActivated discountPolicyActivated = new DiscountPolicyActivated(
                            retargetting
                        );
                        discountPolicyActivated.publishAfterCommit();
                    }
                },
                () -> {
                    Retargetting retargetting = new Retargetting();
                    retargetting.setCustomerId(specCompared.getCustomerId());
                    retargetting.setReturnCount(1);
                    retargetting.setProductId(specCompared.getProductId());
                    repository().save(retargetting);
                }
            );
    }
}
