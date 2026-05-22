package in.abdulmajid.cardiq.offer.controller;

import in.abdulmajid.cardiq.common.ApiResponse;
import in.abdulmajid.cardiq.offer.dto.CreateOfferRequest;
import in.abdulmajid.cardiq.offer.dto.OfferResponse;
import in.abdulmajid.cardiq.offer.service.OfferService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/offers")
@RequiredArgsConstructor
public class OfferController {

    private final OfferService offerService;

    @PostMapping
    public ApiResponse<OfferResponse> createOffer(
            @Valid @RequestBody CreateOfferRequest request
    ) {

        return ApiResponse.<OfferResponse>builder()
                .success(true)
                .message("Offer created successfully")
                .data(offerService.createOffer(request))
                .build();
    }

    @GetMapping
    public ApiResponse<List<OfferResponse>> getAllOffers() {

        return ApiResponse.<List<OfferResponse>>builder()
                .success(true)
                .message("Offers fetched successfully")
                .data(offerService.getAllOffers())
                .build();
    }

    @GetMapping("/{id}")
    public ApiResponse<OfferResponse> getOfferById(
            @PathVariable Long id
    ) {

        return ApiResponse.<OfferResponse>builder()
                .success(true)
                .message("Offer fetched successfully")
                .data(offerService.getOfferById(id))
                .build();
    }

    @PutMapping("/{id}")
    public ApiResponse<OfferResponse> updateOffer(
            @PathVariable Long id,
            @Valid @RequestBody CreateOfferRequest request
    ) {

        return ApiResponse.<OfferResponse>builder()
                .success(true)
                .message("Offer updated successfully")
                .data(offerService.updateOffer(id, request))
                .build();
    }

    @DeleteMapping("/{id}")
    public ApiResponse<Void> deleteOffer(
            @PathVariable Long id
    ) {

        offerService.deleteOffer(id);

        return ApiResponse.<Void>builder()
                .success(true)
                .message("Offer deleted successfully")
                .data(null)
                .build();
    }
}