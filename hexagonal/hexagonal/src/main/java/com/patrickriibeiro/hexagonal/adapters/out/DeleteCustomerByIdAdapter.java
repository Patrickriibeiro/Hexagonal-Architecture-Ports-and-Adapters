package com.patrickriibeiro.hexagonal.adapters.out;

import com.patrickriibeiro.hexagonal.adapters.out.repository.CustomerRepository;
import com.patrickriibeiro.hexagonal.application.ports.out.DeleteCustomerByIdOutPutPort;
import org.springframework.beans.factory.annotation.Autowired;

public class DeleteCustomerByIdAdapter implements DeleteCustomerByIdOutPutPort {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public void delete(String id) {
        customerRepository.deleteById(id);
    }
}
