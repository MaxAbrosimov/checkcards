package backend.controllers;

import backend.dto.PlaceDto;
import backend.services.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
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

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/api/places")
public class PlaceController {

    private PlaceService placeService;

    @Autowired
    public PlaceController(PlaceService placeService) {
        this.placeService = placeService;
    }

    @PostMapping(produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(OK)
    public ResponseEntity<PlaceDto> save(@RequestBody PlaceDto customerDto) {
        return new ResponseEntity<>(placeService.saveOrUpdate(customerDto), OK);
    }

    @GetMapping(produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(OK)
    public ResponseEntity<List<PlaceDto>> list() {
        return new ResponseEntity<>(placeService.listAll(), OK);
    }

    @GetMapping(value = "/{pid}", produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(OK)
    public ResponseEntity<PlaceDto> load(@PathVariable String id) {
        return new ResponseEntity<>(placeService.getById(UUID.fromString(id)), OK);
    }

    @DeleteMapping(value = "/{pid}", produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(OK)
    public ResponseEntity delete(@PathVariable String pid) {
        placeService.delete(UUID.fromString(pid));
        return new ResponseEntity(OK);
    }
}
