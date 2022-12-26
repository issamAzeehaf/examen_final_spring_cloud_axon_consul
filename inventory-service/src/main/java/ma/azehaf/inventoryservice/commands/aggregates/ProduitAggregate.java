package ma.azehaf.inventoryservice.commands.aggregates;

import lombok.NoArgsConstructor;
import ma.azehaf.inventoryservice.commonapi.commands.CreateProduitCommand;
import ma.azehaf.inventoryservice.commonapi.enums.StatusProduit;
import ma.azehaf.inventoryservice.commonapi.events.ProduitCreatedEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;

@NoArgsConstructor
public class ProduitAggregate {
    @AggregateIdentifier
    private String id;
    private String nom;
    private double prix;
    private int quantite;
    private StatusProduit status;

    @CommandHandler
    public ProduitAggregate(CreateProduitCommand command) {
        if (command.getNom() == null || command.getNom().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        AggregateLifecycle.apply(new ProduitCreatedEvent(
                command.getId(),
                command.getNom(),
                command.getPrix(),
                command.getQuantite(),
                command.getStatus()));
    }
}
