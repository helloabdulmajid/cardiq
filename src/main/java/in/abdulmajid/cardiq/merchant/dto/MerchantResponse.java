package in.abdulmajid.cardiq.merchant.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class MerchantResponse {

    // =========================================================
    // BASIC DETAILS
    // =========================================================

    private Long id;

    private String name;

    private String slug;

    private String code;

    private String merchantType;

    // =========================================================
    // VISUAL DETAILS
    // =========================================================

    private String logoUrl;

    private String websiteUrl;

    // =========================================================
    // EXTRA DETAILS
    // =========================================================

    private String description;

    private Boolean active;
}