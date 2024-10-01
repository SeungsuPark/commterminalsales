package commterminalsales.domain;

import commterminalsales.domain.*;

import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//<<< PoEAA / Repository
@RepositoryRestResource(
    collectionResourceRel = "retargettings",
    path = "retargettings"
)
public interface RetargettingRepository
    extends PagingAndSortingRepository<Retargetting, Long> {


        Optional<Retargetting> findByCustomerId(String customerId);
    }
