package ma.azehaf.inventoryservice.query.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.azehaf.inventoryservice.commonapi.events.CategorieCreatedEvent;
import ma.azehaf.inventoryservice.commonapi.queries.GetCategorie;
import ma.azehaf.inventoryservice.commonapi.queries.GetCategories;
import ma.azehaf.inventoryservice.query.entities.Categorie;
import ma.azehaf.inventoryservice.query.repositories.CategorieRepository;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class CategorieServiceHandler {
    private CategorieRepository categorieRepository;

    @EventHandler
    @Transactional
    public void on(CategorieCreatedEvent event) {
        Categorie categorie = new Categorie();
        categorie.setId(event.getId());
        categorie.setNom(event.getNom());
        categorie.setDescritpion(event.getDescription());
        categorieRepository.save(categorie);
    }

    @QueryHandler
    public List<Categorie> on(GetCategories query) {
        return categorieRepository.findAll();
    }

    @QueryHandler
    public Categorie on(GetCategorie query) {
        return categorieRepository.findById(query.getId()).get();
    }
}
