package com.patrickriibeiro.hexagonal.adapters.in.controller.mapper;

import com.patrickriibeiro.hexagonal.adapters.in.controller.request.CustomerRequest;
import com.patrickriibeiro.hexagonal.adapters.in.controller.response.CustomerResponse;
import com.patrickriibeiro.hexagonal.application.core.domain.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "address", ignore = true)
    @Mapping(target = "isValidCpf", ignore = true)
    Customer toCustomer(CustomerRequest customerRequest);

    @Mapping(target = "id", ignore = true)
    CustomerResponse toCustomerResponse(Customer customer);

}
