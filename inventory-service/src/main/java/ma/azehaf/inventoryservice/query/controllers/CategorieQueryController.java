package ma.azehaf.inventoryservice.query.controllers;

import lombok.AllArgsConstructor;
import ma.azehaf.inventoryservice.commonapi.queries.GetCategorie;
import ma.azehaf.inventoryservice.commonapi.queries.GetCategories;
import ma.azehaf.inventoryservice.query.entities.Categorie;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/query/categorie")
@AllArgsConstructor
@Service
@CrossOrigin(origins = "*")
public class CategorieQueryController {
    private QueryGateway queryGateway;


    @GetMapping(path = "/")
    public List<Categorie> getcategories() {
        return queryGateway.query(new GetCategories(), ResponseTypes.multipleInstancesOf(Categorie.class)).join();
    }

    @GetMapping(path = "/{id}")
    public Categorie getCategorie(@PathVariable String id) {
        return queryGateway.query(new GetCategorie(id), Categorie.class).join();
    }
}
