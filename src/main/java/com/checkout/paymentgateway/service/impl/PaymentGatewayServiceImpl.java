package com.checkout.paymentgateway.service.impl;

import com.checkout.paymentgateway.model.PaymentGateway;
import com.checkout.paymentgateway.service.PaymentGatewayService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentGatewayServiceImpl implements PaymentGatewayService {
    @Override
    public void save(PaymentGateway paymentGateway) {

    }

    @Override
    public String delete(Long id) {
        return null;
    }

    @Override
    public Optional<PaymentGateway> update(Long id, PaymentGateway paymentGateway) {
        return Optional.empty();
    }

    @Override
    public List<PaymentGateway> findAll() {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public PaymentGateway findById(Long id) {
        return null;
    }
}
