package in.abdulmajid.cardiq.card.entity;

import in.abdulmajid.cardiq.bank.entity.Bank;
import in.abdulmajid.cardiq.common.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Card extends BaseEntity {

    private String name;

    private Double joiningFee;

    private Double annualFee;

    private Boolean active = true;

    @ManyToOne
    private Bank bank;
}