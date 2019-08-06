package backend.services;

import backend.converters.PlaceConverter;
import backend.domain.Place;
import backend.dto.PlaceDto;
import backend.repositories.PlaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class PlaceServiceImpl implements PlaceService {

    private PlaceRepository placeRepository;

    @Autowired
    public PlaceServiceImpl(PlaceRepository placeRepository) {
        this.placeRepository = placeRepository;
    }

    @Override
    public List<PlaceDto> listAll() {
        List<PlaceDto> places = new ArrayList<>();
        placeRepository.findAll().forEach(place -> places.add(PlaceConverter.convertToDto(place)));
        return places;
    }

    @Override
    public PlaceDto getById(UUID id) {
        return PlaceConverter.convertToDto(placeRepository.findById(id).orElse(null));
    }

    @Override
    public PlaceDto saveOrUpdate(PlaceDto dto) {
        Place place = PlaceConverter.convertFromDto(dto);
        placeRepository.save(place);
        return PlaceConverter.convertToDto(place);
    }

    @Override
    public void delete(UUID id) {
        placeRepository.deleteById(id);
    }

}
