package ma.azehaf.orderservice.commonapi.events;

import lombok.Getter;

public class LineCommandeCreatedEvent extends BaseEvent<String>{

    @Getter private int quantiteProduit;

    @Getter private double prixUnitaire;

    @Getter private String remise;

    //constructor
    public LineCommandeCreatedEvent(String id, int quantiteProduit, double prixUnitaire, String remise) {
        super(id);
        this.quantiteProduit = quantiteProduit;
        this.prixUnitaire = prixUnitaire;
        this.remise = remise;
    }
}
