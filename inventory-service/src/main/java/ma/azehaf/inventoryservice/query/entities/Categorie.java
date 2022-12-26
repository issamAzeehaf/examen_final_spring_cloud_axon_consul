package ma.azehaf.inventoryservice.query.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Categorie {
    @Id
    private String id;
    private String nom;
    private String descritpion;
    @OneToMany(mappedBy = "categorie")
    private List<Produit> produits;
}
