package in.abdulmajid.cardiq.card.service;

import in.abdulmajid.cardiq.card.dto.CardResponse;
import in.abdulmajid.cardiq.card.repository.CardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CardService {

    private final CardRepository cardRepository;

    public List<CardResponse> getAllCards() {

        return cardRepository.findAll()
                .stream()
                .map(card -> CardResponse.builder()
                        .id(card.getId())
                        .name(card.getName())
                        .bankName(card.getBank().getName())
                        .network(card.getNetwork())
                        .cardType(card.getCardType())
                        .rewardType(card.getRewardType())
                        .cardLevel(card.getCardLevel())
                        .joiningFee(card.getJoiningFee())
                        .annualFee(card.getAnnualFee())
                        .ltf(card.getLtf())
                        .airportLoungeAccess(card.getAirportLoungeAccess())
                        .railwayLoungeAccess(card.getRailwayLoungeAccess())
                        .fuelSurchargeWaiver(card.getFuelSurchargeWaiver())
                        .coBranded(card.getCoBranded())
                        .description(card.getDescription())
                        .build())
                .toList();
    }
}