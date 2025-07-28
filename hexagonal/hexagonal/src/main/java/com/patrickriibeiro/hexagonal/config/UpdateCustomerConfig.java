package com.patrickriibeiro.hexagonal.config;

import com.patrickriibeiro.hexagonal.adapters.out.FindAddressByZipCodeAdapter;
import com.patrickriibeiro.hexagonal.adapters.out.UpdateCustumerAdapter;
import com.patrickriibeiro.hexagonal.application.core.usercase.FindCustomerByIdUseCase;
import com.patrickriibeiro.hexagonal.application.core.usercase.UpdateCustomerUserCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UpdateCustomerConfig {

    @Bean
    public UpdateCustomerUserCase updateCustomerUserCase(FindCustomerByIdUseCase findCustomerByIdUseCase,
                                                         FindAddressByZipCodeAdapter findAddressByZipCodeAdapter,
                                                         UpdateCustumerAdapter updateCustumerAdapter) {
        return new UpdateCustomerUserCase(findCustomerByIdUseCase, findAddressByZipCodeAdapter, updateCustumerAdapter);
    }
}
