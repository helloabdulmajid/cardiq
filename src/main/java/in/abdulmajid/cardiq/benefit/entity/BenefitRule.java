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

    private String name;

    @Enumerated(EnumType.STRING)
    private BenefitType benefitType;

    private Double rewardPointValue;

    private Double redemptionFee;

    private Integer minimumRedemptionPoints;

    private Boolean expiryApplicable = false;

    private Integer expiryMonths;

    private Boolean statementCreditSupported = false;

    private Boolean walletTransferSupported = false;

    private Boolean travelRedemptionSupported = false;

    private Boolean voucherRedemptionSupported = false;

    @Column(length = 1000)
    private String notes;
}