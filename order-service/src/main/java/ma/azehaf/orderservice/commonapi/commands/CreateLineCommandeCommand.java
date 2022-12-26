package ma.azehaf.orderservice.commonapi.commands;

import lombok.Getter;

public class CreateLineCommandeCommand extends BaseCommand<String> {

    @Getter private int quantiteProduit;
    @Getter private double prixUnitaire;
    @Getter private String remise;

    //constructor
    public CreateLineCommandeCommand(String id, int quantiteProduit, double prixUnitaire, String remise) {
        super(id);
        this.quantiteProduit = quantiteProduit;
        this.prixUnitaire = prixUnitaire;
        this.remise = remise;
    }

}
