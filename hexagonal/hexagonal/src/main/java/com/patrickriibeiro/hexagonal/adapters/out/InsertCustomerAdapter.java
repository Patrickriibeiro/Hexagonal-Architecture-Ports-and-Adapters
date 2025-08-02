package com.patrickriibeiro.hexagonal.adapters.out;

import com.patrickriibeiro.hexagonal.adapters.out.repository.CustomerRepository;
import com.patrickriibeiro.hexagonal.adapters.out.repository.mapper.CustomerEntityMapper;
import com.patrickriibeiro.hexagonal.application.core.domain.Customer;
import com.patrickriibeiro.hexagonal.application.ports.out.InsertCustomerOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class InsertCustomerAdapter implements InsertCustomerOutputPort {

    private final CustomerRepository customerRepository;

    private final CustomerEntityMapper customerEntityMapper;

    @Override
    public void insert(Customer customer) {
        var entity = customerEntityMapper.toCustomerEntity(customer);
        customerRepository.save(entity);
    }
}
