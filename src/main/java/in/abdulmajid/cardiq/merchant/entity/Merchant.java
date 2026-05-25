package in.abdulmajid.cardiq.merchant.entity;

import in.abdulmajid.cardiq.common.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Merchant extends BaseEntity {

    // =========================================================
    // BASIC MERCHANT DETAILS
    // =========================================================

    // Example:
    // Amazon
    // Swiggy
    // Zomato

    private String name;

    // Example:
    // amazon
    // swiggy

    @Column(unique = true)
    private String slug;

    // Example:
    // AMAZON
    // SWIGGY

    private String code;

    // Example:
    // SHOPPING
    // FOOD
    // TRAVEL

    private String merchantType;

    // =========================================================
    // VISUAL & WEBSITE DETAILS
    // =========================================================

    private String logoUrl;

    private String websiteUrl;

    // =========================================================
    // DESCRIPTION
    // =========================================================

    @Column(length = 1000)
    private String description;

    // =========================================================
    // ACTIVE STATUS
    // =========================================================

    private Boolean active = true;
}