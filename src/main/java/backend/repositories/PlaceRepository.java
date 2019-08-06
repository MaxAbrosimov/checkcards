package backend.repositories;

import backend.domain.Place;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface PlaceRepository extends CrudRepository<Place, UUID> {
}
