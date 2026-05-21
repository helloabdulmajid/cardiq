package in.abdulmajid.cardiq.card.service;

import in.abdulmajid.cardiq.card.entity.Card;
import in.abdulmajid.cardiq.card.repository.CardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CardService {

    private final CardRepository cardRepository;

    public List<Card> getAllCards() {
        return cardRepository.findAll();
    }
}