package com.checkout.paymentgateway.service.impl;

import com.checkout.paymentgateway.dto.payment.PaymentDto;
import com.checkout.paymentgateway.dto.paymentGatewayDto.PaymentRequestDto;
import com.checkout.paymentgateway.dto.paymentGatewayDto.PaymentResponseDto;
import com.checkout.paymentgateway.model.Payment;
import com.checkout.paymentgateway.repository.PaymentRepo;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    private final PaymentRepo paymentRepo;

    public PaymentService(PaymentRepo paymentRepo){
        this.paymentRepo = paymentRepo;
    }


    public PaymentResponseDto createPayment(PaymentDto paymentDto){

    }

    public Payment retrievePayment(){

    }


    public void sendRequestToBank() {

    }
}
