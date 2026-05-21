package in.abdulmajid.cardiq.bank.controller;

import in.abdulmajid.cardiq.bank.dto.BankResponse;
import in.abdulmajid.cardiq.bank.dto.CreateBankRequest;
import in.abdulmajid.cardiq.bank.service.BankService;
import in.abdulmajid.cardiq.common.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/banks")
@RequiredArgsConstructor
public class BankController {

    private final BankService bankService;

    @PostMapping
    public ApiResponse<BankResponse> createBank(
            @Valid @RequestBody CreateBankRequest request
    ) {

        return ApiResponse.<BankResponse>builder()
                .success(true)
                .message("Bank created successfully")
                .data(bankService.createBank(request))
                .build();
    }

    @GetMapping
    public ApiResponse<List<BankResponse>> getAllBanks() {

        return ApiResponse.<List<BankResponse>>builder()
                .success(true)
                .message("Banks fetched successfully")
                .data(bankService.getAllBanks())
                .build();
    }
}