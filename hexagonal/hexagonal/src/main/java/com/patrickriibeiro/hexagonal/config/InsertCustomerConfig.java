package com.patrickriibeiro.hexagonal.config;

import com.patrickriibeiro.hexagonal.adapters.out.FindAddressByZipCodeAdapter;
import com.patrickriibeiro.hexagonal.adapters.out.InsertCustomerAdapter;
import com.patrickriibeiro.hexagonal.application.core.usercase.InsertCustomerUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InsertCustomerConfig {

    @Bean
    public InsertCustomerUseCase insertCustomerUseCase(FindAddressByZipCodeAdapter findAddressByZipCodeAdapter,
                                                       InsertCustomerAdapter insertCustomerAdapter) {
        return new InsertCustomerUseCase(findAddressByZipCodeAdapter, insertCustomerAdapter);
    }
}
