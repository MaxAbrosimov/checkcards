package backend.controllers;

import backend.dto.CustomerDto;
import backend.services.CustomerService;
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
@RequestMapping(value = "/api/customers")
public class CustomerController {

    private CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping(produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(OK)
    public ResponseEntity<CustomerDto> save(@RequestBody CustomerDto customerDto) {
        return new ResponseEntity<>(customerService.saveOrUpdate(customerDto), OK);
    }

    @GetMapping(produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(OK)
    public ResponseEntity<List<CustomerDto>> list() {
        return new ResponseEntity<>(customerService.listAll(), OK);
    }

    @GetMapping(value = "/{cid}", produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(OK)
    public ResponseEntity<CustomerDto> load(@PathVariable String cid) {
        return new ResponseEntity<>(customerService.getById(UUID.fromString(cid)), OK);
    }

    @DeleteMapping(value = "/{cid}", produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(OK)
    public ResponseEntity delete(@PathVariable String cid) {
        customerService.delete(UUID.fromString(cid));
        return new ResponseEntity(OK);
    }

}
