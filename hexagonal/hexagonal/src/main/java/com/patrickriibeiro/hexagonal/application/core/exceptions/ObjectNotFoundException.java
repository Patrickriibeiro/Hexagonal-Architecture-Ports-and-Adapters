package com.patrickriibeiro.hexagonal.application.core.exceptions;

public class ObjectNotFoundException extends RuntimeException{

    public ObjectNotFoundException(final String id){
        super("Object with id " + id + " not found ");
    };

}
