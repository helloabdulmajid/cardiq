package in.abdulmajid.cardiq.offer.service;

import in.abdulmajid.cardiq.benefit.entity.BenefitRule;
import in.abdulmajid.cardiq.card.entity.Card;
import in.abdulmajid.cardiq.card.repository.CardRepository;
import in.abdulmajid.cardiq.category.entity.Category;
import in.abdulmajid.cardiq.category.repository.CategoryRepository;
import in.abdulmajid.cardiq.exception.DuplicateResourceException;
import in.abdulmajid.cardiq.exception.ResourceNotFoundException;
import in.abdulmajid.cardiq.merchant.entity.Merchant;
import in.abdulmajid.cardiq.merchant.repository.MerchantRepository;
import in.abdulmajid.cardiq.offer.dto.CreateOfferRequest;
import in.abdulmajid.cardiq.offer.dto.OfferResponse;
import in.abdulmajid.cardiq.offer.entity.Offer;
import in.abdulmajid.cardiq.offer.repository.OfferRepository;
import in.abdulmajid.cardiq.benefit.repository.BenefitRuleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OfferService {

    private final OfferRepository offerRepository;

    private final CardRepository cardRepository;

    private final MerchantRepository merchantRepository;

    private final CategoryRepository categoryRepository;
    private final BenefitRuleRepository benefitRuleRepository;

    public OfferResponse createOffer(
            CreateOfferRequest request
    ) {

        validateDates(request);

        Card card = cardRepository.findById(request.getCardId())
                .orElseThrow(() ->
                        new ResourceNotFoundException("Card not found")
                );

        Merchant merchant = merchantRepository.findById(request.getMerchantId())
                .orElseThrow(() ->
                        new ResourceNotFoundException("Merchant not found")
                );

        Category category = categoryRepository.findById(request.getCategoryId())
                .orElseThrow(() ->
                        new ResourceNotFoundException("Category not found")
                );
        BenefitRule benefitRule =
                benefitRuleRepository.findById(
                                request.getBenefitRuleId()
                        )
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Benefit rule not found"
                                )
                        );

        Offer offer = new Offer();

        mapRequestToEntity(
                offer,
                request,
                card,
                merchant,
                category,
                benefitRule
        );

        Offer savedOffer = offerRepository.save(offer);

        return mapToResponse(savedOffer);
    }

    public List<OfferResponse> getAllOffers() {

        return offerRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    public OfferResponse getOfferById(Long id) {

        Offer offer = offerRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Offer not found")
                );

        return mapToResponse(offer);
    }

    public OfferResponse updateOffer(
            Long id,
            CreateOfferRequest request
    ) {

        validateDates(request);

        Offer offer = offerRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Offer not found")
                );

        Card card = cardRepository.findById(request.getCardId())
                .orElseThrow(() ->
                        new ResourceNotFoundException("Card not found")
                );

        Merchant merchant = merchantRepository.findById(request.getMerchantId())
                .orElseThrow(() ->
                        new ResourceNotFoundException("Merchant not found")
                );

        Category category = categoryRepository.findById(request.getCategoryId())
                .orElseThrow(() ->
                        new ResourceNotFoundException("Category not found")
                );
        BenefitRule benefitRule =
                benefitRuleRepository.findById(
                                request.getBenefitRuleId()
                        )
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Benefit rule not found"
                                )
                        );

        mapRequestToEntity(
                offer,
                request,
                card,
                merchant,
                category,
                benefitRule
        );

        Offer updatedOffer = offerRepository.save(offer);

        return mapToResponse(updatedOffer);
    }

    public void deleteOffer(Long id) {

        Offer offer = offerRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Offer not found")
                );

        offerRepository.delete(offer);
    }

    private void validateDates(
            CreateOfferRequest request
    ) {

        if (request.getEndDate()
                .isBefore(request.getStartDate())) {

            throw new DuplicateResourceException(
                    "End date cannot be before start date"
            );
        }
    }

    private void mapRequestToEntity(
            Offer offer,
            CreateOfferRequest request,
            Card card,
            Merchant merchant,
            Category category,
            BenefitRule benefitRule
    ) {

        offer.setTitle(request.getTitle());

        offer.setDescription(request.getDescription());

        offer.setOfferType(request.getOfferType());

        offer.setValue(request.getValue());

        offer.setMaxBenefit(request.getMaxBenefit());

        offer.setMinimumSpend(request.getMinimumSpend());

        offer.setActive(request.getActive());

        offer.setStartDate(request.getStartDate());

        offer.setEndDate(request.getEndDate());

        offer.setVerifiedAt(request.getVerifiedAt());

        offer.setSourceUrl(request.getSourceUrl());

        offer.setPlatform(request.getPlatform());

        offer.setBenefitPeriod(request.getBenefitPeriod());

        offer.setApplicableNetwork(
                request.getApplicableNetwork()
        );

        offer.setMilestoneBenefit(
                request.getMilestoneBenefit()
        );

        offer.setLimitedTimeOffer(
                request.getLimitedTimeOffer()
        );

        offer.setPriority(request.getPriority());

        offer.setPermanentOffer(
                request.getPermanentOffer()
        );

        offer.setCard(card);

        offer.setMerchant(merchant);

        offer.setCategory(category);
        offer.setBenefitRule(benefitRule);
    }

    private OfferResponse mapToResponse(
            Offer offer
    ) {

        return OfferResponse.builder()
                .id(offer.getId())
                .title(offer.getTitle())
                .description(offer.getDescription())
                .offerType(offer.getOfferType())
                .value(offer.getValue())
                .maxBenefit(offer.getMaxBenefit())
                .minimumSpend(offer.getMinimumSpend())
                .active(offer.getActive())
                .startDate(offer.getStartDate())
                .endDate(offer.getEndDate())
                .verifiedAt(offer.getVerifiedAt())
                .sourceUrl(offer.getSourceUrl())
                .cardName(offer.getCard().getName())
                .merchantName(
                        offer.getMerchant().getName()
                )
                .categoryName(
                        offer.getCategory().getName()
                )
                .platform(offer.getPlatform())
                .benefitPeriod(
                        offer.getBenefitPeriod()
                )
                .applicableNetwork(
                        offer.getApplicableNetwork()
                )
                .milestoneBenefit(
                        offer.getMilestoneBenefit()
                )
                .limitedTimeOffer(
                        offer.getLimitedTimeOffer()
                )
                .priority(offer.getPriority())
                .permanentOffer(
                        offer.getPermanentOffer()
                )
                .build();
    }
}