package in.abdulmajid.cardiq.merchant.repository;

import in.abdulmajid.cardiq.merchant.entity.Merchant;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MerchantRepository extends JpaRepository<Merchant, Long> {

    // =========================================================
    // CHECK DUPLICATE MERCHANT NAME
    // =========================================================

    boolean existsByNameIgnoreCase(String name);

    // =========================================================
    // CHECK DUPLICATE MERCHANT SLUG
    // =========================================================

    boolean existsBySlug(String slug);
}