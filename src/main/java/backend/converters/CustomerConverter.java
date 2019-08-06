package backend.converters;

import backend.domain.Customer;
import backend.dto.CustomerDto;
import org.springframework.util.StringUtils;

public class CustomerConverter {

    public static Customer convertFromDto(CustomerDto customerDto) {
        Customer customer = new Customer();
        if (customerDto.getId() != null  && !StringUtils.isEmpty(customerDto.getId())) {
            customer.setId(customerDto.getId());
        }
        customer.setFirstName(customerDto.getFirstName());
        customer.setLastName(customerDto.getLastName());
        customer.setEmail(customerDto.getEmail());
        return customer;
    }

    public static CustomerDto convertToDto(Customer customer) {
        if (customer == null) {
            return null;
        }
        CustomerDto dto = new CustomerDto();
        dto.setId(customer.getId());
        dto.setFirstName(customer.getFirstName());
        dto.setLastName(customer.getLastName());
        dto.setEmail(customer.getEmail());
        return dto;
    }

}
