package in.abdulmajid.cardiq.offer.repository;

import in.abdulmajid.cardiq.offer.entity.Offer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OfferRepository extends JpaRepository<Offer, Long> {
}