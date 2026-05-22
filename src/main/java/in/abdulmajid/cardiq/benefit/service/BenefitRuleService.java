package in.abdulmajid.cardiq.benefit.service;

import in.abdulmajid.cardiq.benefit.dto.BenefitRuleResponse;
import in.abdulmajid.cardiq.benefit.dto.CreateBenefitRuleRequest;
import in.abdulmajid.cardiq.benefit.entity.BenefitRule;
import in.abdulmajid.cardiq.benefit.repository.BenefitRuleRepository;
import in.abdulmajid.cardiq.exception.DuplicateResourceException;
import in.abdulmajid.cardiq.exception.ResourceNotFoundException;
import in.abdulmajid.cardiq.offer.repository.OfferRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BenefitRuleService {

    private final BenefitRuleRepository benefitRuleRepository;

    private final OfferRepository offerRepository;

    public BenefitRuleResponse createRule(
            CreateBenefitRuleRequest request
    ) {

        BenefitRule rule = new BenefitRule();

        mapRequestToEntity(rule, request);

        BenefitRule savedRule =
                benefitRuleRepository.save(rule);

        return mapToResponse(savedRule);
    }

    public List<BenefitRuleResponse> getAllRules() {

        return benefitRuleRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    public BenefitRuleResponse getRuleById(
            Long id
    ) {

        BenefitRule rule =
                benefitRuleRepository.findById(id)
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Benefit rule not found"
                                )
                        );

        return mapToResponse(rule);
    }

    public BenefitRuleResponse updateRule(
            Long id,
            CreateBenefitRuleRequest request
    ) {

        BenefitRule rule =
                benefitRuleRepository.findById(id)
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Benefit rule not found"
                                )
                        );

        mapRequestToEntity(rule, request);

        BenefitRule updatedRule =
                benefitRuleRepository.save(rule);

        return mapToResponse(updatedRule);
    }

    public void deleteRule(Long id) {

        BenefitRule rule =
                benefitRuleRepository.findById(id)
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Benefit rule not found"
                                )
                        );

        if (offerRepository.existsByBenefitRule(rule)) {

            throw new DuplicateResourceException(
                    "Cannot delete benefit rule because offers are associated with it"
            );
        }

        benefitRuleRepository.delete(rule);
    }

    private void mapRequestToEntity(
            BenefitRule rule,
            CreateBenefitRuleRequest request
    ) {

        rule.setName(request.getName());

        rule.setBenefitType(
                request.getBenefitType()
        );

        rule.setRewardPointValue(
                request.getRewardPointValue()
        );

        rule.setRedemptionFee(
                request.getRedemptionFee()
        );

        rule.setMinimumRedemptionPoints(
                request.getMinimumRedemptionPoints()
        );

        rule.setExpiryApplicable(
                request.getExpiryApplicable()
        );

        rule.setExpiryMonths(
                request.getExpiryMonths()
        );

        rule.setStatementCreditSupported(
                request.getStatementCreditSupported()
        );

        rule.setWalletTransferSupported(
                request.getWalletTransferSupported()
        );

        rule.setTravelRedemptionSupported(
                request.getTravelRedemptionSupported()
        );

        rule.setVoucherRedemptionSupported(
                request.getVoucherRedemptionSupported()
        );

        rule.setNotes(request.getNotes());
    }

    private BenefitRuleResponse mapToResponse(
            BenefitRule rule
    ) {

        return BenefitRuleResponse.builder()
                .id(rule.getId())
                .name(rule.getName())
                .benefitType(rule.getBenefitType())
                .rewardPointValue(
                        rule.getRewardPointValue()
                )
                .redemptionFee(
                        rule.getRedemptionFee()
                )
                .minimumRedemptionPoints(
                        rule.getMinimumRedemptionPoints()
                )
                .expiryApplicable(
                        rule.getExpiryApplicable()
                )
                .expiryMonths(
                        rule.getExpiryMonths()
                )
                .statementCreditSupported(
                        rule.getStatementCreditSupported()
                )
                .walletTransferSupported(
                        rule.getWalletTransferSupported()
                )
                .travelRedemptionSupported(
                        rule.getTravelRedemptionSupported()
                )
                .voucherRedemptionSupported(
                        rule.getVoucherRedemptionSupported()
                )
                .notes(rule.getNotes())
                .build();
    }
}