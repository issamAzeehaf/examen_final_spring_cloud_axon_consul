package ma.azehaf.customerservice.commonapi.events;

import lombok.Data;
import lombok.Getter;


public class CustomerCreatedEvent extends BaseEvent<String> {
    @Getter private String nom;
    @Getter private String adresse;
    @Getter private String email;
    @Getter private String telephone;

    //constructor
    public CustomerCreatedEvent(String id, String nom, String adresse, String email, String telephone) {
        super(id);
        this.nom = nom;
        this.adresse = adresse;
        this.email = email;
        this.telephone = telephone;
    }
}
