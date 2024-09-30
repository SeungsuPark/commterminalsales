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
//<<< DDD / Aggregate Root
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

    //<<< Clean Arch / Port Method
    public static void 스펙재방문시타켓팅수치증가(SpecCompared specCompared) {
        //implement business logic here:

        /** Example 1:  new item 
        Retargetting retargetting = new Retargetting();
        repository().save(retargetting);

        DiscountPolicyActivated discountPolicyActivated = new DiscountPolicyActivated(retargetting);
        discountPolicyActivated.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(specCompared.get???()).ifPresent(retargetting->{
            
            retargetting // do something
            repository().save(retargetting);

            DiscountPolicyActivated discountPolicyActivated = new DiscountPolicyActivated(retargetting);
            discountPolicyActivated.publishAfterCommit();

         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
