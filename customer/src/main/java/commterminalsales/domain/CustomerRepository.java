package commterminalsales.domain;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import commterminalsales.domain.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//<<< PoEAA / Repository
@RepositoryRestResource(collectionResourceRel="customers", path="customers")
public interface CustomerRepository extends PagingAndSortingRepository<Customer, >{
    @Query(value = "select customer " +
        "from Customer customer " +
        "where(:id is null or customer.id like %:id%)")
       Customer findByGetCustomer
(String id);
}