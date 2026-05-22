package in.abdulmajid.cardiq.benefit.dto;

import in.abdulmajid.cardiq.benefit.enums.BenefitType;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class BenefitRuleResponse {

    private Long id;

    private String name;

    private BenefitType benefitType;

    private Double rewardPointValue;

    private Double redemptionFee;

    private Integer minimumRedemptionPoints;

    private Boolean expiryApplicable;

    private Integer expiryMonths;

    private Boolean statementCreditSupported;

    private Boolean walletTransferSupported;

    private Boolean travelRedemptionSupported;

    private Boolean voucherRedemptionSupported;

    private String notes;
}