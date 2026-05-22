package in.abdulmajid.cardiq.offer.entity;

import in.abdulmajid.cardiq.benefit.entity.BenefitRule;
import in.abdulmajid.cardiq.card.entity.Card;
import in.abdulmajid.cardiq.card.enums.CardNetwork;
import in.abdulmajid.cardiq.category.entity.Category;
import in.abdulmajid.cardiq.common.BaseEntity;
import in.abdulmajid.cardiq.merchant.entity.Merchant;
import in.abdulmajid.cardiq.offer.enums.BenefitPeriod;
import in.abdulmajid.cardiq.offer.enums.OfferPlatform;
import in.abdulmajid.cardiq.offer.enums.OfferType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
public class Offer extends BaseEntity {

    @Column(nullable = false,length = 255)
    private String title;

    @Column(length = 2000)
    private String description;

    @Enumerated(EnumType.STRING)
    private OfferType offerType;

    private Double value;

    private Double maxBenefit;

    private Double minimumSpend;

    private Boolean active = true;

    private LocalDate startDate;

    private LocalDate endDate;

    private LocalDate verifiedAt;

    private String sourceUrl;

    @ManyToOne
    private Card card;

    @ManyToOne
    private Merchant merchant;

    @ManyToOne
    private Category category;

    @Enumerated(EnumType.STRING)
    private OfferPlatform platform;

    @Enumerated(EnumType.STRING)
    private BenefitPeriod benefitPeriod;

    @Enumerated(EnumType.STRING)
    private CardNetwork applicableNetwork;

    @Column(length = 1000)
    private String milestoneBenefit;
    private Boolean limitedTimeOffer = false;
    private Integer priority = 0;
    private Boolean permanentOffer = false;

    @ManyToOne
    private BenefitRule benefitRule;
}