package com.patrickriibeiro.hexagonal.adapters.out;

import com.patrickriibeiro.hexagonal.adapters.out.repository.CustomerRepository;
import com.patrickriibeiro.hexagonal.adapters.out.repository.mapper.CustomerEntityMapper;
import com.patrickriibeiro.hexagonal.application.core.domain.Customer;
import com.patrickriibeiro.hexagonal.application.ports.out.FindCustomerByIdOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class FindCustomerByIdAdapter implements FindCustomerByIdOutputPort {

    private final CustomerRepository customerRepository;

    private final CustomerEntityMapper customerEntityMapper;

    @Override
    public Optional<Customer> find(String id) {
        var customerEntity = customerRepository.findById(id);
        return customerEntity.map(customerEntityMapper::toCustomer);
    }
}
