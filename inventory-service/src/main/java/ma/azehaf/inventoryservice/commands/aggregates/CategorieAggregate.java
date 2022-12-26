package ma.azehaf.inventoryservice.commands.aggregates;

import lombok.NoArgsConstructor;
import ma.azehaf.inventoryservice.commonapi.commands.CreateCategorieCommand;
import ma.azehaf.inventoryservice.commonapi.events.CategorieCreatedEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;

@NoArgsConstructor // Required by Axon
public class CategorieAggregate {
    @AggregateIdentifier
    private String id;
    private String nom;
    private String description;

    @CommandHandler
    public CategorieAggregate(CreateCategorieCommand command) {
        if (command.getNom() == null || command.getNom().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        AggregateLifecycle.apply(new CategorieCreatedEvent(
                command.getId(),
                command.getNom(),
                command.getDescription()));
    }


}
