package in.abdulmajid.cardiq.bank.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class BankResponse {

    // =========================================================
    // BANK RESPONSE DATA
    // =========================================================

    private Long id;

    private String name;

    private String shortName;

    private String slug;

    private String logoUrl;

    private String websiteUrl;

    private Boolean active;
}