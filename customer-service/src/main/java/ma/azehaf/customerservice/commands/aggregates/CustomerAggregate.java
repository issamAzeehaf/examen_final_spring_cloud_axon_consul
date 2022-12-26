package ma.azehaf.customerservice.commands.aggregates;

import lombok.NoArgsConstructor;
import ma.azehaf.customerservice.commonapi.commands.CreateCustomerCommand;
import ma.azehaf.customerservice.commonapi.events.CustomerCreatedEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

@Aggregate
@NoArgsConstructor
public class CustomerAggregate {
    @AggregateIdentifier
    private String customerId;
    private String nom;
    private String adresse;
    private String email;
    private String telephone;
    @CommandHandler
    public CustomerAggregate(CreateCustomerCommand createCustomerCommand) {
        AggregateLifecycle.apply(new CustomerCreatedEvent(
                createCustomerCommand.getId(),
                createCustomerCommand.getNom(),
                createCustomerCommand.getAdresse(),
                createCustomerCommand.getEmail(),
                createCustomerCommand.getTelephone()
        ));
    }
    @EventSourcingHandler
    public void on(CustomerCreatedEvent customerCreatedEvent) {
        this.customerId = customerCreatedEvent.getId();
        this.nom = customerCreatedEvent.getNom();
        this.adresse = customerCreatedEvent.getAdresse();
        this.email = customerCreatedEvent.getEmail();
        this.telephone = customerCreatedEvent.getTelephone();
    }
}
