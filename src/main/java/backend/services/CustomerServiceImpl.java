package backend.services;

import backend.converters.CustomerConverter;
import backend.domain.Customer;
import backend.dto.CustomerDto;
import backend.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class CustomerServiceImpl implements CustomerService {

    private CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<CustomerDto> listAll() {
        List<CustomerDto> users = new ArrayList<>();
        customerRepository.findAll().forEach(user -> users.add(CustomerConverter.convertToDto(user)));
        return users;
    }

    @Override
    public CustomerDto getById(UUID id) {
        return CustomerConverter.convertToDto(customerRepository.findById(id).orElse(null));
    }

    @Override
    public CustomerDto saveOrUpdate(CustomerDto dto) {
        Customer customer = CustomerConverter.convertFromDto(dto);
        customerRepository.save(customer);
        return CustomerConverter.convertToDto(customer);
    }

    @Override
    public void delete(UUID id) {
        customerRepository.deleteById(id);
    }
}
