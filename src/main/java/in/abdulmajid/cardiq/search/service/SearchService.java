package in.abdulmajid.cardiq.search.service;

import in.abdulmajid.cardiq.exception.ResourceNotFoundException;
import in.abdulmajid.cardiq.offer.repository.OfferRepository;
import in.abdulmajid.cardiq.search.dto.SearchCardResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SearchService {

    private final OfferRepository offerRepository;

    public List<SearchCardResponse> search(String keyword) {

        if (keyword == null || keyword.isBlank()) {
            throw new ResourceNotFoundException(
                    "Search keyword is required"
            );
        }

        List<SearchCardResponse> results = offerRepository
                .findDistinctByTitleContainingIgnoreCaseOrMerchant_NameContainingIgnoreCaseOrCategory_NameContainingIgnoreCaseOrCard_NameContainingIgnoreCaseOrCard_Bank_NameContainingIgnoreCaseOrderByPriorityDescValueDesc(
                        keyword,
                        keyword,
                        keyword,
                        keyword,
                        keyword
                )
                .stream()
                .map(offer -> SearchCardResponse.builder()
                        .cardName(offer.getCard().getName())
                        .bankName(offer.getCard().getBank().getName())
                        .offerTitle(offer.getTitle())
                        .value(offer.getValue())
                        .offerType(offer.getOfferType())
                        .merchantName(offer.getMerchant().getName())
                        .categoryName(offer.getCategory().getName())
                        .platform(offer.getPlatform())

                        .permanentOffer(
                                offer.getPermanentOffer()
                        )

                        .limitedTimeOffer(
                                offer.getLimitedTimeOffer()
                        )
                        .imageUrl(
                                offer.getCard().getImageUrl()
                        )

                        .network(
                                offer.getCard().getNetwork().name()
                        )

                        .rewardType(
                                offer.getCard().getRewardType().name()
                        )

                        .priority(
                                offer.getPriority()
                        )
                        .build())
                .toList();

        if (results.isEmpty()) {
            throw new ResourceNotFoundException("No offers found");
        }

        return results;
    }
}