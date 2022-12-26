package ma.azehaf.customerservice.query.repositories;

import ma.azehaf.customerservice.query.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, String> {

}

