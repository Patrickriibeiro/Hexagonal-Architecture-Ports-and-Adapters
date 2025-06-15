package com.patrickriibeiro.hexagonal.application.core.usercase;

import com.patrickriibeiro.hexagonal.application.core.domain.Customer;
import com.patrickriibeiro.hexagonal.application.ports.out.FindCustomerByIdOutPutPort;

public class FindCustomerByIdUseCase {

    private final FindCustomerByIdOutPutPort findCustomerByIdOutPutPort;

    public FindCustomerByIdUseCase(FindCustomerByIdOutPutPort findCustomerByIdOutPutPort) {
        this.findCustomerByIdOutPutPort = findCustomerByIdOutPutPort;
    }

    public Customer find(String id) {
        return this.findCustomerByIdOutPutPort.find(id).orElseThrow(()
                -> new RuntimeException("Customer not Found."));
    }

}
