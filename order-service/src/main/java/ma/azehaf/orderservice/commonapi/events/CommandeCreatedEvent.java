package ma.azehaf.orderservice.commonapi.events;

import lombok.Getter;

import java.util.Date;

public class CommandeCreatedEvent extends BaseEvent<String> {
    @Getter private Date dateCommande;

    @Getter private Date dateLivraison;

    @Getter private String adresseLivraison;

    //constructor
    public CommandeCreatedEvent(String id, Date dateCommande, Date dateLivraison, String adresseLivraison) {
        super(id);
        this.dateCommande = dateCommande;
        this.dateLivraison = dateLivraison;
        this.adresseLivraison = adresseLivraison;
    }

}
