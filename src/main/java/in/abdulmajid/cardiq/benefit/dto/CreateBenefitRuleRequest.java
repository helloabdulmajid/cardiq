package in.abdulmajid.cardiq.benefit.dto;

import in.abdulmajid.cardiq.benefit.enums.BenefitType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateBenefitRuleRequest {

    @NotBlank(message = "Rule name is required")
    private String name;

    @NotNull(message = "Benefit type is required")
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

    private String notes;
}