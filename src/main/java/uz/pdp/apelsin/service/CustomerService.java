package uz.pdp.apelsin.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.pdp.apelsin.dto.ApiResponse;
import uz.pdp.apelsin.entity.Customer;
import uz.pdp.apelsin.repository.CustomerRepository;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CustomerService {

    final CustomerRepository customerRepository;

    public ApiResponse add(Customer customer) {
        Customer save = new Customer();
        save.setName(customer.getName());
        save.setAddress(customer.getAddress());
        save.setCountry(customer.getCountry());
        save.setPhone(customer.getPhone());
        customerRepository.save(save);
        return new ApiResponse("Saved", true);
    }

    public ApiResponse edit(Integer id, Customer customer) {

        Optional<Customer> byId = customerRepository.findById(id);
        if (byId.isEmpty()) return new ApiResponse("Customer Not found!", false);

        Customer edited = byId.get();
        edited.setName(customer.getName());
        edited.setAddress(customer.getAddress());
        edited.setCountry(customer.getCountry());
        edited.setPhone(customer.getPhone());
        customerRepository.save(edited);

        return new ApiResponse("Edited", true);
    }
}
