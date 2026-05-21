package in.abdulmajid.cardiq.card.controller;

import in.abdulmajid.cardiq.card.dto.CardResponse;
import in.abdulmajid.cardiq.card.dto.CreateCardRequest;
import in.abdulmajid.cardiq.card.entity.Card;
import in.abdulmajid.cardiq.card.service.CardService;
import in.abdulmajid.cardiq.common.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/cards")
@RequiredArgsConstructor
public class CardController {

    private final CardService cardService;

    @GetMapping
    List<CardResponse> getAllCards() {
        return cardService.getAllCards();
    }

    @PostMapping
    public ApiResponse<CardResponse> createCard(
            @Valid @RequestBody CreateCardRequest request
    ) {

        return ApiResponse.<CardResponse>builder()
                .success(true)
                .message("Card created successfully")
                .data(cardService.createCard(request))
                .build();
    }
}