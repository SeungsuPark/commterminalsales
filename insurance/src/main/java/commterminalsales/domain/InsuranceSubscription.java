package commterminalsales.domain;

import commterminalsales.InsuranceApplication;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "InsuranceSubscription_table")
@Data
//<<< DDD / Aggregate Root
public class InsuranceSubscription {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String customerId;

    private String productId;

    private String terminalProductId;

    public static InsuranceSubscriptionRepository repository() {
        InsuranceSubscriptionRepository insuranceSubscriptionRepository = InsuranceApplication.applicationContext.getBean(
            InsuranceSubscriptionRepository.class
        );
        return insuranceSubscriptionRepository;
    }

    //<<< Clean Arch / Port Method
    public static void subscribeInsurance(OrderPlaced orderPlaced) {
        //implement business logic here:

        /** Example 1:  new item 
        InsuranceSubscription insuranceSubscription = new InsuranceSubscription();
        repository().save(insuranceSubscription);

        */

        /** Example 2:  finding and process
        
        repository().findById(orderPlaced.get???()).ifPresent(insuranceSubscription->{
            
            insuranceSubscription // do something
            repository().save(insuranceSubscription);


         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
