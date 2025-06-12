package com.patrickriibeiro.hexagonal.application.ports.out;

import com.patrickriibeiro.hexagonal.application.core.domain.Address;

public interface FindAddressByZipCodeOutputPort {

    Address find(String zipCode);

}
