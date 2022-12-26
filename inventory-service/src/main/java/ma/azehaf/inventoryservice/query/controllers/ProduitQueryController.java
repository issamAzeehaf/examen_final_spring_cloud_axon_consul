package ma.azehaf.inventoryservice.query.controllers;

import lombok.AllArgsConstructor;
import ma.azehaf.inventoryservice.commonapi.queries.GetCategorie;
import ma.azehaf.inventoryservice.commonapi.queries.GetProduit;
import ma.azehaf.inventoryservice.commonapi.queries.GetProduits;
import ma.azehaf.inventoryservice.query.entities.Categorie;
import ma.azehaf.inventoryservice.query.entities.Produit;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/query/produit")
@AllArgsConstructor
@Service
@CrossOrigin(origins = "*")
public class ProduitQueryController {
    private QueryGateway queryGateway;


    @GetMapping(path = "/")
    public List<Produit> getproduits() {
        return queryGateway.query(new GetProduits(), ResponseTypes.multipleInstancesOf(Produit.class)).join();
    }

    @GetMapping(path = "/{id}")
    public Produit getProduit(@PathVariable String id) {
        return queryGateway.query(new GetProduit(id), Produit.class).join();
    }
}
