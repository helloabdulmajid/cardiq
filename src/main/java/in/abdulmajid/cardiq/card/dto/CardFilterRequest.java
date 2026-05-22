package in.abdulmajid.cardiq.card.dto;

import in.abdulmajid.cardiq.card.enums.CardNetwork;
import in.abdulmajid.cardiq.card.enums.CardType;
import in.abdulmajid.cardiq.card.enums.RewardType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CardFilterRequest {

    private Boolean ltf;

    private Boolean airportLoungeAccess;

    private Boolean railwayLoungeAccess;

    private Boolean fuelSurchargeWaiver;

    private CardNetwork network;

    private CardType cardType;

    private RewardType rewardType;

    private Double maxAnnualFee;
}