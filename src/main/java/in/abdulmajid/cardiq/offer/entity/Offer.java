package in.abdulmajid.cardiq.offer.entity;

import in.abdulmajid.cardiq.card.entity.Card;
import in.abdulmajid.cardiq.category.entity.Category;
import in.abdulmajid.cardiq.common.BaseEntity;
import in.abdulmajid.cardiq.merchant.entity.Merchant;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Offer extends BaseEntity {

    private String title;

    private String description;

    private Double cashbackPercentage;

    private Double maxCashback;

    private Boolean active = true;

    @ManyToOne
    private Card card;

    @ManyToOne
    private Merchant merchant;

    @ManyToOne
    private Category category;
}