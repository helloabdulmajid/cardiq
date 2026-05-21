package in.abdulmajid.cardiq.bank.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateBankRequest {

    @NotBlank(message = "Bank name is required")
    private String name;

    private String logoUrl;

    private String websiteUrl;
}