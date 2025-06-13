package com.patrickriibeiro.hexagonal.adapters.out.client.mapper;

import com.patrickriibeiro.hexagonal.adapters.out.client.response.AddressResponse;
import com.patrickriibeiro.hexagonal.application.core.domain.Address;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AddressResponseMapper {

    Address toAddress(AddressResponse addressResponse);

}
