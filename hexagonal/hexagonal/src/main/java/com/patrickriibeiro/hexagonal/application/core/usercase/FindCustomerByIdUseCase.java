package com.patrickriibeiro.hexagonal.application.core.usercase;

import com.patrickriibeiro.hexagonal.application.core.domain.Customer;
import com.patrickriibeiro.hexagonal.application.core.exceptions.ObjectNotFoundException;
import com.patrickriibeiro.hexagonal.application.ports.in.FindCustomerByIdInputPort;
import com.patrickriibeiro.hexagonal.application.ports.out.FindCustomerByIdOutPutPort;

public class FindCustomerByIdUseCase implements FindCustomerByIdInputPort {

    private final FindCustomerByIdOutPutPort findCustomerByIdOutPutPort;

    public FindCustomerByIdUseCase(FindCustomerByIdOutPutPort findCustomerByIdOutPutPort) {
        this.findCustomerByIdOutPutPort = findCustomerByIdOutPutPort;
    }

    @Override
    public Customer find(String id) {
        return this.findCustomerByIdOutPutPort.find(id).orElseThrow(()
                -> new ObjectNotFoundException(id));
    }

}
