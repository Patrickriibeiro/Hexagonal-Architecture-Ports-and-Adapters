package com.patrickriibeiro.hexagonal.adapters.out;

import com.patrickriibeiro.hexagonal.adapters.in.controller.mapper.CustomerMapper;
import com.patrickriibeiro.hexagonal.adapters.out.repository.CustomerRepository;
import com.patrickriibeiro.hexagonal.adapters.out.repository.mapper.CustomerEntityMapper;
import com.patrickriibeiro.hexagonal.application.core.domain.Customer;
import com.patrickriibeiro.hexagonal.application.ports.out.UpdateCustomerOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UpdateCustumerAdapter implements UpdateCustomerOutputPort {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerEntityMapper customerEntityMapper;

    @Override
    public void update(Customer customer) {
        var custumerEntity = customerEntityMapper.toCustomerEntity(customer);
        customerRepository.save(custumerEntity);
    }
}
