package in.abdulmajid.cardiq.card.repository;

import in.abdulmajid.cardiq.card.entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepository extends JpaRepository<Card, Long> {
}