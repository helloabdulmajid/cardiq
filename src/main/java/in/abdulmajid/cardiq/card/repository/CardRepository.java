package in.abdulmajid.cardiq.card.repository;

import in.abdulmajid.cardiq.card.entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CardRepository extends JpaRepository<Card, Long>, JpaSpecificationExecutor<Card> {

    boolean existsByBank_Id(Long bankId);
    boolean existsByNameIgnoreCase(String name);

}