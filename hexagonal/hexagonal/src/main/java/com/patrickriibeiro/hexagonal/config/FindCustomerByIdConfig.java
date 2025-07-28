package com.patrickriibeiro.hexagonal.config;

import com.patrickriibeiro.hexagonal.adapters.out.FindAddressByZipCodeAdapter;
import com.patrickriibeiro.hexagonal.adapters.out.FindCustomerByIdAdapter;
import com.patrickriibeiro.hexagonal.adapters.out.InsertCustomerAdapter;
import com.patrickriibeiro.hexagonal.application.core.usercase.FindCustomerByIdUseCase;
import com.patrickriibeiro.hexagonal.application.core.usercase.InsertCustomerUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FindCustomerByIdConfig {

    @Bean
    public FindCustomerByIdUseCase findCustomerByIdUseCase (FindCustomerByIdAdapter findCustomerByIdAdapter) {
        return new FindCustomerByIdUseCase(findCustomerByIdAdapter);
    }
}
