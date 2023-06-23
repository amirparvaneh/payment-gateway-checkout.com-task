package com.checkout.paymentgateway.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class PaymentException extends Exception{
    private String message;

    public PaymentException(String errorMessage){
        super(errorMessage);
    }
}
