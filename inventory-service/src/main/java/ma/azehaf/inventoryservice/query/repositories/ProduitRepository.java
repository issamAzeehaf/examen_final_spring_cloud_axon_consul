package ma.azehaf.inventoryservice.query.repositories;

import ma.azehaf.inventoryservice.query.entities.Produit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProduitRepository extends JpaRepository<Produit, String> {
}
