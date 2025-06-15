package com.patrickriibeiro.hexagonal.application.ports.in;

import com.patrickriibeiro.hexagonal.application.core.domain.Customer;

public interface FindCustomerByIdInputPort {

    Customer find(String id);

}
