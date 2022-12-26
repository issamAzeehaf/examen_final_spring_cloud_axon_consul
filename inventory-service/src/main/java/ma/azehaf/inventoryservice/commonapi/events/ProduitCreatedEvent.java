package ma.azehaf.inventoryservice.commonapi.events;

import lombok.Getter;
import ma.azehaf.inventoryservice.commonapi.enums.StatusProduit;

public class ProduitCreatedEvent extends BaseEvent<String>{
    @Getter private String nom;
    @Getter private double prix;
    @Getter private int quantite;
    @Getter private StatusProduit status;

    //constructor
    public ProduitCreatedEvent(String id, String nom, double prix, int quantite, StatusProduit status) {
        super(id);
        this.nom = nom;
        this.prix = prix;
        this.quantite = quantite;
        this.status = status;
    }
}
