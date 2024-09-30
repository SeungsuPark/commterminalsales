package commterminalsales.domain;

import commterminalsales.domain.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//<<< PoEAA / Repository
@RepositoryRestResource(
    collectionResourceRel = "insuranceSubscriptions",
    path = "insuranceSubscriptions"
)
public interface InsuranceSubscriptionRepository
    extends PagingAndSortingRepository<InsuranceSubscription, Long> {}
