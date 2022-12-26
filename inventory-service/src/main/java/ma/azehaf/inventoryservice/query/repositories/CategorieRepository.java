package ma.azehaf.inventoryservice.query.repositories;

import ma.azehaf.inventoryservice.query.entities.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategorieRepository extends JpaRepository<Categorie, String> {

}

