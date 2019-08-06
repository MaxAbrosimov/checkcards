package backend.converters;

import backend.domain.Place;
import backend.dto.PlaceDto;
import org.springframework.util.StringUtils;

public class PlaceConverter {

    public static Place convertFromDto(PlaceDto placeDto) {
        Place place = new Place();
        if (!StringUtils.isEmpty(placeDto.getId())) {
            place.setId(placeDto.getId());
        }
        place.setName(placeDto.getName());
        place.setDelimiter(placeDto.getDelimiter());
        return place;
    }

    public static PlaceDto convertToDto(Place place) {
        if (place == null) {
            return null;
        }
        PlaceDto dto = new PlaceDto();
        dto.setId(place.getId());
        dto.setName(place.getName());
        dto.setDelimiter(place.getDelimiter());
        return dto;
    }

}
