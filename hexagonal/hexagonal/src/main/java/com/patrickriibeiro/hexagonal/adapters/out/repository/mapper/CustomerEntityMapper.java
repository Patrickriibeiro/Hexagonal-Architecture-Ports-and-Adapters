package com.patrickriibeiro.hexagonal.adapters.out.repository.mapper;

import com.patrickriibeiro.hexagonal.adapters.out.repository.entity.CustomerEntity;
import com.patrickriibeiro.hexagonal.application.core.domain.Customer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerEntityMapper {

    CustomerEntity toCustomerEntity(Customer Customer);

}
