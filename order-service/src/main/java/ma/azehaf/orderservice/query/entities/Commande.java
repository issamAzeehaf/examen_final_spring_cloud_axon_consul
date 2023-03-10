package ma.azehaf.orderservice.query.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.azehaf.orderservice.commonapi.enums.StatusCommande;

import java.util.Date;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Commande {
    @Id
    private String id;
    private Date dateCommande;
    private Date dateLivraison;
    private String adresseLivraison;
    private StatusCommande status;

}
