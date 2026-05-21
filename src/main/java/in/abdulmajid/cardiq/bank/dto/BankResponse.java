package in.abdulmajid.cardiq.bank.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class BankResponse {

    private Long id;

    private String name;

    private String logoUrl;

    private String websiteUrl;
}