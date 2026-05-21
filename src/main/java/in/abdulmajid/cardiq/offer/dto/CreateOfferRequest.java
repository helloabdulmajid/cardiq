package in.abdulmajid.cardiq.offer.dto;

import in.abdulmajid.cardiq.offer.enums.OfferType;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class CreateOfferRequest {

    @NotBlank(message = "Offer title is required")
    private String title;

    private String description;

    @NotNull(message = "Offer type is required")
    private OfferType offerType;

    @NotNull(message = "Offer value is required")
    @Min(value = 0, message = "Offer value cannot be negative")
    private Double value;

    @Min(value = 0, message = "Maximum benefit cannot be negative")
    private Double maxBenefit;

    @Min(value = 0, message = "Minimum spend cannot be negative")
    private Double minimumSpend;

    private Boolean active = true;

    @NotNull(message = "Start date is required")
    private LocalDate startDate;

    @NotNull(message = "End date is required")
    private LocalDate endDate;

    private String sourceUrl;

    @NotNull(message = "Card ID is required")
    private Long cardId;

    @NotNull(message = "Merchant ID is required")
    private Long merchantId;

    @NotNull(message = "Category ID is required")
    private Long categoryId;
}