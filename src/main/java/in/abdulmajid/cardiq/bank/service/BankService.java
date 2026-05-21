package in.abdulmajid.cardiq.bank.service;

import in.abdulmajid.cardiq.bank.dto.BankResponse;
import in.abdulmajid.cardiq.bank.dto.CreateBankRequest;
import in.abdulmajid.cardiq.bank.entity.Bank;
import in.abdulmajid.cardiq.bank.repository.BankRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BankService {

    private final BankRepository bankRepository;

    public BankResponse createBank(CreateBankRequest request) {

        Bank bank = new Bank();

        bank.setName(request.getName());
        bank.setLogoUrl(request.getLogoUrl());
        bank.setWebsiteUrl(request.getWebsiteUrl());

        Bank savedBank = bankRepository.save(bank);

        return BankResponse.builder()
                .id(savedBank.getId())
                .name(savedBank.getName())
                .logoUrl(savedBank.getLogoUrl())
                .websiteUrl(savedBank.getWebsiteUrl())
                .build();
    }

    public List<BankResponse> getAllBanks() {

        return bankRepository.findAll()
                .stream()
                .map(bank -> BankResponse.builder()
                        .id(bank.getId())
                        .name(bank.getName())
                        .logoUrl(bank.getLogoUrl())
                        .websiteUrl(bank.getWebsiteUrl())
                        .build())
                .toList();
    }
}