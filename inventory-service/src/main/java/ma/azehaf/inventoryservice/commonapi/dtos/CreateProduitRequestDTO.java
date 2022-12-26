package ma.azehaf.inventoryservice.commonapi.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class CreateProduitRequestDTO {
    private String nom;
    private double prix;
    private int quantite;
    private String categorieId;
}
