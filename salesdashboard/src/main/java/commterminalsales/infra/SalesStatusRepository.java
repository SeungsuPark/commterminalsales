package commterminalsales.infra;

import commterminalsales.domain.*;
import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(
    collectionResourceRel = "salesStatuses",
    path = "salesStatuses"
)
public interface SalesStatusRepository
    extends PagingAndSortingRepository<SalesStatus, Long> {}
