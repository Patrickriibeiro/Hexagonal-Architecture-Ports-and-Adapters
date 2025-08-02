package com.patrickriibeiro.hexagonal.application.core.usecase;

import com.patrickriibeiro.hexagonal.application.core.domain.Customer;
import com.patrickriibeiro.hexagonal.application.core.exceptions.ObjectNotFoundException;
import com.patrickriibeiro.hexagonal.application.ports.in.FindCustomerByIdInputPort;
import com.patrickriibeiro.hexagonal.application.ports.out.FindCustomerByIdOutputPort;

public class FindCustomerByIdUseCase implements FindCustomerByIdInputPort {

    private final FindCustomerByIdOutputPort findCustomerByIdOutputPort;

    public FindCustomerByIdUseCase(FindCustomerByIdOutputPort findCustomerByIdOutputPort) {
        this.findCustomerByIdOutputPort = findCustomerByIdOutputPort;
    }

    @Override
    public Customer find(String id) {
        return this.findCustomerByIdOutputPort.find(id).orElseThrow(()
                -> new ObjectNotFoundException(id));
    }

}
