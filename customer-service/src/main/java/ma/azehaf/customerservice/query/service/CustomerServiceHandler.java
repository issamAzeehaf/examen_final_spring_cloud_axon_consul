package ma.azehaf.customerservice.query.service;

import ma.azehaf.customerservice.commonapi.events.CustomerCreatedEvent;
import ma.azehaf.customerservice.commonapi.queries.FindAllRadars;
import ma.azehaf.customerservice.query.entities.Customer;
import ma.azehaf.customerservice.query.repositories.CustomerRepository;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class CustomerServiceHandler {
    private CustomerRepository customerRepository;

    @EventHandler
    @Transactional
    public void on(CustomerCreatedEvent event){
        Customer customer = new Customer();
        customer.setId(event.getId());
        customer.setNom(event.getNom());
        customer.setAdresse(event.getAdresse());
        customer.setEmail(event.getEmail());
        customer.setTelephone(event.getTelephone());
        customerRepository.save(customer);
    }

    @QueryHandler
    public List<Customer> on(FindAllRadars query){
        return customerRepository.findAll();
    }
}
