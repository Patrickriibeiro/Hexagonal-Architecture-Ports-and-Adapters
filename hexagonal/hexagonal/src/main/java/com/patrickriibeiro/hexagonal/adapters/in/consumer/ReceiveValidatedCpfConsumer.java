package com.patrickriibeiro.hexagonal.adapters.in.consumer;

import com.patrickriibeiro.hexagonal.adapters.in.consumer.mapper.CustomerMessageMapper;
import com.patrickriibeiro.hexagonal.adapters.in.consumer.message.CustomerMessage;
import com.patrickriibeiro.hexagonal.application.ports.in.UpdateCustomerInputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@KafkaListener(topics = "tp-cpf-validated", groupId = "oliveira")
public class ReceiveValidatedCpfConsumer {

    @Autowired
    private UpdateCustomerInputPort updateCustomerInputPort;

    @Autowired
    private CustomerMessageMapper customerMessageMapper;

    public void receive(CustomerMessage customerMessage){
        var customer = customerMessageMapper.toCustomer(customerMessage);
        updateCustomerInputPort.update(customer, customerMessage.getZipCode());
    }

}
