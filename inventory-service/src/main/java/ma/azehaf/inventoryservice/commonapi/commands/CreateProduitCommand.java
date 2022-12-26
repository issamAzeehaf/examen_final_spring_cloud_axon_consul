package ma.azehaf.inventoryservice.commonapi.commands;

import lombok.Getter;
import ma.azehaf.inventoryservice.commonapi.enums.StatusProduit;

public class CreateProduitCommand extends BaseCommand<String>{
    @Getter public String nom;
    @Getter public double prix;
    @Getter public int quantite;

    @Getter public StatusProduit status;

    @Getter String categorieId;

    //constructor
    public CreateProduitCommand(String id, String nom, double prix, int quantite, String categorieId) {
        super(id);
        this.nom = nom;
        this.prix = prix;
        this.quantite = quantite;
        this.categorieId = categorieId;
    }

}
