package com.patrickriibeiro.hexagonal.application.ports.in;

import com.patrickriibeiro.hexagonal.application.core.domain.Customer;

public interface UpdateCustomerInputPort {

    void update(Customer customer, String zipCode);

}
