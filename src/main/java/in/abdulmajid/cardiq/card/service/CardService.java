package in.abdulmajid.cardiq.card.service;

import in.abdulmajid.cardiq.bank.entity.Bank;
import in.abdulmajid.cardiq.bank.repository.BankRepository;
import in.abdulmajid.cardiq.card.dto.CardResponse;
import in.abdulmajid.cardiq.card.dto.CreateCardRequest;
import in.abdulmajid.cardiq.card.entity.Card;
import in.abdulmajid.cardiq.card.repository.CardRepository;
import in.abdulmajid.cardiq.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CardService {

    private final CardRepository cardRepository;
    private final BankRepository bankRepository;

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

    public CardResponse createCard(CreateCardRequest request) {

        Bank bank = bankRepository.findById(request.getBankId())
                .orElseThrow(() ->
                        new ResourceNotFoundException("Bank not found")
                );

        Card card = new Card();

        card.setName(request.getName());
        card.setJoiningFee(request.getJoiningFee());
        card.setAnnualFee(request.getAnnualFee());

        card.setNetwork(request.getNetwork());
        card.setCardType(request.getCardType());
        card.setRewardType(request.getRewardType());
        card.setCardLevel(request.getCardLevel());

        card.setBank(bank);

        Card savedCard = cardRepository.save(card);

        return CardResponse.builder()
                .id(savedCard.getId())
                .name(savedCard.getName())
                .bankName(savedCard.getBank().getName())
                .network(savedCard.getNetwork())
                .cardType(savedCard.getCardType())
                .rewardType(savedCard.getRewardType())
                .cardLevel(savedCard.getCardLevel())
                .joiningFee(savedCard.getJoiningFee())
                .annualFee(savedCard.getAnnualFee())
                .ltf(savedCard.getLtf())
                .airportLoungeAccess(savedCard.getAirportLoungeAccess())
                .railwayLoungeAccess(savedCard.getRailwayLoungeAccess())
                .fuelSurchargeWaiver(savedCard.getFuelSurchargeWaiver())
                .coBranded(savedCard.getCoBranded())
                .description(savedCard.getDescription())
                .build();
    }



}