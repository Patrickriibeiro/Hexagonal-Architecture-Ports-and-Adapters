package com.patrickriibeiro.hexagonal.application.ports.in;

import com.patrickriibeiro.hexagonal.application.core.domain.Customer;

public interface InsertCustomerInputPort {

    void insert(Customer customer, String zipCode);

}
