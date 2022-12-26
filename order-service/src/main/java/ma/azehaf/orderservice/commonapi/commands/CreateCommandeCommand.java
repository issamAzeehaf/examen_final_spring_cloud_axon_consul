package ma.azehaf.orderservice.commonapi.commands;

import lombok.Getter;

import java.util.Date;

public class CreateCommandeCommand extends BaseCommand<String> {

    @Getter private Date dateCommande;
    @Getter private Date dateLivraison;
    @Getter private String adresseLivraison;

    //constructor
    public CreateCommandeCommand(String id, Date dateCommande, Date dateLivraison, String adresseLivraison) {
        super(id);
        this.dateCommande = dateCommande;
        this.dateLivraison = dateLivraison;
        this.adresseLivraison = adresseLivraison;
    }



}
