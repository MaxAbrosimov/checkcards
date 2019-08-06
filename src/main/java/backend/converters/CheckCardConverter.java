package backend.converters;

import backend.domain.CheckCard;
import backend.domain.CheckCardKey;
import backend.dto.CheckCardDto;

public class CheckCardConverter {

    public static CheckCard convertFromDto(CheckCardDto checkCardDto) {
        CheckCard checkCard = new CheckCard();
        CheckCardKey checkCardKey = new CheckCardKey();
        checkCardKey.setCustomerId(checkCardDto.getCustomerId());
        checkCardKey.setPlaceId(checkCardDto.getPlaceId());
        checkCard.setKey(checkCardKey);
        checkCard.setChecks(checkCardDto.getChecks());
        checkCard.setDelimiter(checkCardDto.getDelimiter());
        checkCard.setStyleId(checkCardDto.getStyleId());
        return checkCard;
    }

    public static CheckCardDto convertToDto(CheckCard checkCard) {
        CheckCardDto dto = new CheckCardDto();
        if (checkCard.getKey() != null) {
            dto.setCustomerId(checkCard.getKey().getCustomerId());
            dto.setPlaceId(checkCard.getKey().getPlaceId());
        }
        dto.setChecks(checkCard.getChecks());
        dto.setDelimiter(checkCard.getDelimiter());
        dto.setAvailableHits(checkCard.getChecks() / checkCard.getDelimiter());
        dto.setStyleId(checkCard.getStyleId());
        return dto;
    }

}
