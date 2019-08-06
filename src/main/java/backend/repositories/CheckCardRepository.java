package backend.repositories;

import backend.domain.CheckCard;
import backend.domain.CheckCardKey;
import org.springframework.data.repository.CrudRepository;

public interface CheckCardRepository extends CrudRepository<CheckCard, CheckCardKey> {

}
