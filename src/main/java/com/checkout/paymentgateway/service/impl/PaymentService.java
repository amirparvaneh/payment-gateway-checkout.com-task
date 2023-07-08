package com.checkout.paymentgateway.service.impl;

import com.checkout.paymentgateway.model.Payment;
import com.checkout.paymentgateway.repository.PaymentRepo;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    private final PaymentRepo paymentRepo;

    public PaymentService(PaymentRepo paymentRepo){
        this.paymentRepo = paymentRepo;
    }


    public Payment createPayment(){

    }

    public Payment retrievePayment(){

    }

}
