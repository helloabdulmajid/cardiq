package in.abdulmajid.cardiq.card.controller;

import in.abdulmajid.cardiq.card.entity.Card;
import in.abdulmajid.cardiq.card.service.CardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/cards")
@RequiredArgsConstructor
public class CardController {

    private final CardService cardService;

    @GetMapping
    public List<Card> getAllCards() {
        return cardService.getAllCards();
    }
}