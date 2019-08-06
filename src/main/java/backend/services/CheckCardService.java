package backend.services;

import backend.dto.CheckCardDto;

import java.util.List;
import java.util.UUID;

public interface CheckCardService {

    CheckCardDto getById(String customerId, String placeId);

    List<CheckCardDto> getByCustomerId(String customerId);

    CheckCardDto saveOrUpdate(CheckCardDto product);

    void delete(UUID customerId, UUID placeId);


}
