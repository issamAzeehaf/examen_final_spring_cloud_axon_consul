package ma.azehaf.inventoryservice.commonapi.commands;

import lombok.Getter;

import java.util.Date;

public class CreateCategorieCommand extends BaseCommand<String>{
    @Getter
    public String nom;
    @Getter public String description;

    //constructor
    public CreateCategorieCommand(String id, String nom, String description) {
        super(id);
        this.nom = nom;
        this.description = description;
    }
}
