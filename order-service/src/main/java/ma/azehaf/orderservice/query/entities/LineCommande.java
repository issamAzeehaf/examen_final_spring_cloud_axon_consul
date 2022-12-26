package ma.azehaf.orderservice.query.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class LineCommande {
    @Id
    private String id;
    private int quantiteProduit;
    private double prixUnitaire;
    private String remise;
}
