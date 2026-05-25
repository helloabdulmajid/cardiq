package in.abdulmajid.cardiq.offer.repository;

import in.abdulmajid.cardiq.benefit.entity.BenefitRule;
import in.abdulmajid.cardiq.offer.entity.Offer;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OfferRepository
        extends JpaRepository<Offer, Long> {

    // =========================================================
    // ACTIVE OFFERS
    // =========================================================

    List<Offer> findByActiveTrue();

    // =========================================================
    // RELATION CHECKS
    // =========================================================

    boolean existsByCard_Id(Long cardId);

    boolean existsByMerchant_Id(Long merchantId);

    boolean existsByCategory_Id(Long categoryId);

    boolean existsByBenefitRule(
            BenefitRule benefitRule
    );
}