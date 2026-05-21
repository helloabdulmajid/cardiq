package in.abdulmajid.cardiq.offer.dto;

import in.abdulmajid.cardiq.card.enums.CardNetwork;
import in.abdulmajid.cardiq.offer.enums.BenefitPeriod;
import in.abdulmajid.cardiq.offer.enums.OfferPlatform;
import in.abdulmajid.cardiq.offer.enums.OfferType;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@Builder
public class OfferResponse {

    private Long id;

    private String title;

    private String description;

    private OfferType offerType;

    private Double value;

    private Double maxBenefit;

    private Double minimumSpend;

    private Boolean active;

    private LocalDate startDate;

    private LocalDate endDate;

    private LocalDate verifiedAt;

    private String sourceUrl;

    private String cardName;

    private String merchantName;

    private String categoryName;

    private OfferPlatform platform;

    private BenefitPeriod benefitPeriod;

    private CardNetwork applicableNetwork;

    private String milestoneBenefit;

    private Boolean limitedTimeOffer;

    private Integer priority;

    private Boolean permanentOffer;
}