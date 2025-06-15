package com.patrickriibeiro.hexagonal.application.ports.out;

import com.patrickriibeiro.hexagonal.application.core.domain.Customer;

import java.util.Optional;

public interface FindCustomerByIdOutPutPort {

    Optional<Customer> find(String id);

}
