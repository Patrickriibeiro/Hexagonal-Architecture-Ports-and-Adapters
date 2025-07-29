package com.patrickriibeiro.hexagonal.adapters.in.consumer.mapper;

import com.patrickriibeiro.hexagonal.adapters.in.consumer.message.CustomerMessage;
import com.patrickriibeiro.hexagonal.application.core.domain.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CustomerMessageMapper {


    @Mapping(target = "address", ignore = true)
    Customer toCustomer(CustomerMessage customerMessage);

}
