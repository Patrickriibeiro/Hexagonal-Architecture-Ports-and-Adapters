package com.patrickriibeiro.hexagonal.application.core.usercase;

import com.patrickriibeiro.hexagonal.application.ports.in.FindCustomerByIdInputPort;
import com.patrickriibeiro.hexagonal.application.ports.out.DeleteCustomerByIdOutPutPort;

public class DeleteCustumerByIdUseCase {

    private final FindCustomerByIdInputPort findCustomerByIdInputPort;

    private final DeleteCustomerByIdOutPutPort deleteCustomerByIdOutPutPort;

    public DeleteCustumerByIdUseCase(FindCustomerByIdInputPort findCustomerByIdInputPort, DeleteCustomerByIdOutPutPort deleteCustomerByIdOutPutPort) {
        this.findCustomerByIdInputPort = findCustomerByIdInputPort;
        this.deleteCustomerByIdOutPutPort = deleteCustomerByIdOutPutPort;
    }

    public void delete(String id) {
        findCustomerByIdInputPort.find(id);
        deleteCustomerByIdOutPutPort.delete(id);
    }

}
