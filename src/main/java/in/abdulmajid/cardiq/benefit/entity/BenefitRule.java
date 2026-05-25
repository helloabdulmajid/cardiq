package in.abdulmajid.cardiq.benefit.entity;

import in.abdulmajid.cardiq.benefit.enums.BenefitType;
import in.abdulmajid.cardiq.common.BaseEntity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class BenefitRule extends BaseEntity {

    // =========================================================
    // BASIC DETAILS
    // =========================================================

    // Example:
    // Cashback Rule
    // Reward Points Rule

    private String name;

    // =========================================================
    // BENEFIT CREDIT TYPE
    // =========================================================

    @Enumerated(EnumType.STRING)
    private BenefitType benefitType;

    // =========================================================
    // REWARD POINT CONVERSION
    // =========================================================

    // Example:
    // 1 RP = ₹0.25

    private Double rewardPointConversion;

    // =========================================================
    // MINIMUM REDEMPTION RULE
    // =========================================================

    // Example:
    // Minimum 500 points required

    private Integer minimumRedemptionPoints;

    // =========================================================
    // EXPIRY RULES
    // =========================================================

    // Example:
    // true = points expire
    // false = lifetime points

    private Boolean expiryApplicable = false;

    // Example:
    // reward points expire after 24 months

    private Integer expiryMonths;

    // =========================================================
    // REDEMPTION FEES
    // =========================================================

    // Example:
    // ₹99 redemption fee

    private Double redemptionFee;

    // =========================================================
    // EXTRA NOTES
    // =========================================================

    @Column(length = 1000)
    private String notes;
}