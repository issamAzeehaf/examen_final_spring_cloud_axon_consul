package ma.azehaf.customerservice.query.controllers;

import lombok.AllArgsConstructor;
import ma.azehaf.customerservice.commonapi.queries.FindAllRadars;
import ma.azehaf.customerservice.query.entities.Customer;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/query/customer")
@AllArgsConstructor
public class CustomerRestController {
    private QueryGateway queryGateway;
    @GetMapping("/allCustomers")
    public List<Customer>getAllCustomers(){
        return queryGateway.query(new FindAllRadars(), ResponseTypes.multipleInstancesOf(Customer.class)).join();
    }
}

