package in.abdulmajid.cardiq.offer.entity;

import in.abdulmajid.cardiq.card.entity.Card;
import in.abdulmajid.cardiq.category.entity.Category;
import in.abdulmajid.cardiq.common.BaseEntity;
import in.abdulmajid.cardiq.merchant.entity.Merchant;
import in.abdulmajid.cardiq.offer.enums.OfferType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
public class Offer extends BaseEntity {

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
}