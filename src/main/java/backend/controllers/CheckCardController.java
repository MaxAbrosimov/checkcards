package backend.controllers;

import backend.dto.CheckCardDto;
import backend.services.CheckCardService;
import backend.validators.CheckCardValidator;
import org.springframework.beans.factory.annotation.Autowired;
import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api/checkCards")
public class CheckCardController {

    private CheckCardService checkCardService;

    @Autowired
    public CheckCardController(CheckCardService checkCardService) {
        this.checkCardService = checkCardService;
    }

    @PostMapping(produces = APPLICATION_JSON_VALUE)
    @Produces({MediaType.APPLICATION_JSON})
    public ResponseEntity save(@RequestBody CheckCardDto checkCardDto) {
        List<String> errors = CheckCardValidator.validateCard(checkCardDto);
        if (!errors.isEmpty()) {
            return new ResponseEntity<>(errors.stream().map(String::valueOf).collect(Collectors.joining()), BAD_REQUEST);
        }
        return new ResponseEntity<>(checkCardService.saveOrUpdate(checkCardDto), OK);
    }

    @GetMapping(value = "/customer/{cid}/place/{pid}", produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(OK)
    public ResponseEntity<CheckCardDto> getCard(@PathVariable(value = "cid") String cid, @PathVariable("pid") String pid) {
        return new ResponseEntity<>(checkCardService.getById(cid, pid), OK);
    }

    @GetMapping(value = "/{cid}", produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(OK)
    public ResponseEntity<List<CheckCardDto>> getCards(@PathVariable(value = "cid") String cid) {
        return new ResponseEntity<>(checkCardService.getByCustomerId(cid), OK);
    }

    @DeleteMapping(value = "customer/{cid}/place/{pid}", produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(OK)
    public ResponseEntity delete(@PathVariable(value = "cid") String cid, @PathVariable(value = "pid") String pid) {
        checkCardService.delete(UUID.fromString(cid), UUID.fromString(pid));
        return new ResponseEntity(OK);
    }

}
