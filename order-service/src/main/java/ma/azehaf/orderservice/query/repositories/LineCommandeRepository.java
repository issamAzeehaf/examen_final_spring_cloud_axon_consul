package ma.azehaf.orderservice.query.repositories;

import ma.azehaf.orderservice.query.entities.LineCommande;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LineCommandeRepository extends JpaRepository<LineCommande, String> {
}
