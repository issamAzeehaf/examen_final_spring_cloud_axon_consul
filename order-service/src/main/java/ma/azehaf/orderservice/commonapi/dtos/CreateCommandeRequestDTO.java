package ma.azehaf.orderservice.commonapi.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data @NoArgsConstructor @AllArgsConstructor
public class CreateCommandeRequestDTO {
    private Date dateCommande;
    private Date dateLivraison;
    private String adresseLivraison;

}
