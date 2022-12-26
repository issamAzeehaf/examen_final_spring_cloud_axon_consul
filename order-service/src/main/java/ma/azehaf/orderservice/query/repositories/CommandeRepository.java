package ma.azehaf.orderservice.query.repositories;

import ma.azehaf.orderservice.query.entities.Commande;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommandeRepository extends JpaRepository<Commande, String> {
}
