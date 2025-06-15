package com.patrickriibeiro.hexagonal.adapters.in.controller.response;

import lombok.Data;

@Data
public class CustomerResponse {

    private String name;

    private String cpf;

    private AddressReponse address;

    private Boolean isValidCpf;

}
