package ma.azehaf.inventoryservice.query.entities;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.azehaf.inventoryservice.commonapi.enums.StatusProduit;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Produit {
    @Id
    private String id;
    private String nom;
    private double prix;
    private int quantite;
    private StatusProduit statusProduit;
    @ManyToOne
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Categorie categorie;

}
