
package commterminalsales.external;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Date;
import java.util.List;


@FeignClient(name = "customer", url = "${api.url.customer}")
 
public interface CustomerService {
    @GetMapping(path="/customers/search/findByGetCustomer/{id}")
    public Customer getCustomer(@PathVariableGetCustomerQuery getCustomerQuery);

}



