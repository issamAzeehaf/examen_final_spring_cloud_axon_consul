package ma.azehaf.inventoryservice.query.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.azehaf.inventoryservice.commonapi.events.CategorieCreatedEvent;
import ma.azehaf.inventoryservice.commonapi.events.ProduitCreatedEvent;
import ma.azehaf.inventoryservice.commonapi.queries.GetCategorie;
import ma.azehaf.inventoryservice.commonapi.queries.GetCategories;
import ma.azehaf.inventoryservice.commonapi.queries.GetProduit;
import ma.azehaf.inventoryservice.commonapi.queries.GetProduits;
import ma.azehaf.inventoryservice.query.entities.Categorie;
import ma.azehaf.inventoryservice.query.entities.Produit;
import ma.azehaf.inventoryservice.query.repositories.CategorieRepository;
import ma.azehaf.inventoryservice.query.repositories.ProduitRepository;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j

public class ProduitServiceHandler {
    private ProduitRepository produitRepository;

    @EventHandler
    @Transactional
    public void on(ProduitCreatedEvent event) {
        Produit produit = new Produit();
        produit.setId(event.getId());
        produit.setNom(event.getNom());
        produit.setPrix(event.getPrix());
        produit.setQuantite(event.getQuantite());
        produitRepository.save(produit);
    }

    @QueryHandler
    public List<Produit> on(GetProduits query) {
        return produitRepository.findAll();
    }

    @QueryHandler
    public Produit on(GetProduit query) {
        return produitRepository.findById(query.getId()).get();
    }
}
