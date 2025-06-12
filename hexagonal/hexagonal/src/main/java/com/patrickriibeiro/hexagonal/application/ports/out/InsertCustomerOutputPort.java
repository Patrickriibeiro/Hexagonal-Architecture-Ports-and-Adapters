package com.patrickriibeiro.hexagonal.application.ports.out;

import com.patrickriibeiro.hexagonal.application.core.domain.Customer;

public interface InsertCustomerOutputPort {

    void insert(Customer customer);

}
