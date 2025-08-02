package com.patrickriibeiro.hexagonal.adapters.in.controller.handler;

import com.patrickriibeiro.hexagonal.application.core.exceptions.ObjectNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<StandardError> objectNotFoundExceptionHandler(ObjectNotFoundException e, HttpServletRequest request){
        StandardError standardError = new StandardError(System.currentTimeMillis(),
                HttpStatus.NOT_FOUND.value(),
                e.getMessage(),
                request.getRequestURI());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(standardError);
    }

}
