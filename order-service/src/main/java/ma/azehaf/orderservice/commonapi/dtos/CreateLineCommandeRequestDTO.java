package ma.azehaf.orderservice.commonapi.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class CreateLineCommandeRequestDTO {
private int quantiteProduit;
    private double prixUnitaire;
    private String remise;

}
