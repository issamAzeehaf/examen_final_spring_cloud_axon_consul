package ma.azehaf.inventoryservice.commonapi.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class CreateCategorieRequestDTO {
    private String nom;
    private String description;

}
