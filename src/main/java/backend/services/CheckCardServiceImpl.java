package backend.services;

import backend.converters.CheckCardConverter;
import backend.domain.CheckCard;
import backend.domain.CheckCardKey;
import backend.dto.CheckCardDto;
import backend.repositories.CheckCardRepository;
import com.datastax.driver.core.querybuilder.QueryBuilder;
import com.datastax.driver.core.querybuilder.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class CheckCardServiceImpl implements CheckCardService {

    private CheckCardRepository checkCardRepository;
    private CassandraOperations cassandraOperations;

    @Autowired
    public CheckCardServiceImpl(CheckCardRepository checkCardRepository, CassandraOperations cassandraOperations) {
        this.checkCardRepository = checkCardRepository;
        this.cassandraOperations = cassandraOperations;
    }

    @Override
    public CheckCardDto getById(String customerId, String placeId) {
        CheckCardKey checkCardKey = new CheckCardKey();
        checkCardKey.setCustomerId(UUID.fromString(customerId));
        checkCardKey.setPlaceId(UUID.fromString(placeId));
        return CheckCardConverter.convertToDto(checkCardRepository.findById(checkCardKey).orElse(new CheckCard()));
    }

    @Override
    public List<CheckCardDto> getByCustomerId(String customerId) {
        Select select = QueryBuilder.select().from("customer_check_cards");
        select.where(QueryBuilder.eq("customer_id", UUID.fromString(customerId)));
        return new ArrayList<>(cassandraOperations.select(select, CheckCard.class).stream().map(CheckCardConverter::convertToDto).collect(Collectors.toList()));
    }

    @Override
    public CheckCardDto saveOrUpdate(CheckCardDto checkCardDto) {
        CheckCard checkCard = CheckCardConverter.convertFromDto(checkCardDto);
        checkCardRepository.save(checkCard);
        return CheckCardConverter.convertToDto(checkCard);
    }

    @Override
    public void delete(UUID customerId, UUID placeId) {
        CheckCardKey checkCardKey = new CheckCardKey();
        checkCardKey.setCustomerId(customerId);
        checkCardKey.setPlaceId(placeId);
        checkCardRepository.deleteById(checkCardKey);
    }
}
