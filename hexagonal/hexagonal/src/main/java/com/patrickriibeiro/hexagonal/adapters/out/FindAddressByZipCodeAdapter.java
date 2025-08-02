package com.patrickriibeiro.hexagonal.adapters.out;

import com.patrickriibeiro.hexagonal.adapters.out.client.FindAddressByZipCodeClient;
import com.patrickriibeiro.hexagonal.adapters.out.client.mapper.AddressResponseMapper;
import com.patrickriibeiro.hexagonal.application.core.domain.Address;
import com.patrickriibeiro.hexagonal.application.ports.out.FindAddressByZipCodeOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FindAddressByZipCodeAdapter implements FindAddressByZipCodeOutputPort {

    private final FindAddressByZipCodeClient findAddressByZipCodeClient;

    private final AddressResponseMapper addressResponseMapper;

    @Override
    public Address find(String zipCode) {
        var addressResponse = findAddressByZipCodeClient.find(zipCode);
        return addressResponseMapper.toAddress(addressResponse);
    }
}
