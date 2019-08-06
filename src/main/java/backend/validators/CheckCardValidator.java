package backend.validators;

import backend.dto.CheckCardDto;

import java.util.ArrayList;
import java.util.List;

public class CheckCardValidator {

    public static List<String> validateCard(CheckCardDto checkCard) {
        List<String> errors = new ArrayList<>();
        if (checkCard.getCustomerId() == null) {
            errors.add("Customer must be specified");
        }
        if (checkCard.getPlaceId() == null) {
            errors.add("Place must be specified");
        }
        if (checkCard.getChecks() == null || checkCard.getChecks() < 0) {
            errors.add("Checks must be positive number");
        }
        if (checkCard.getDelimiter() == null || checkCard.getDelimiter() < 0) {
            errors.add("Delimiter must be positive number");
        }
        return errors;
    }

}
