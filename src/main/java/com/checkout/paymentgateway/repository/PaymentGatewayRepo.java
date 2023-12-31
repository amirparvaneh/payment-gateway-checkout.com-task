package com.checkout.paymentgateway.repository;

import com.checkout.paymentgateway.model.PaymentGateway;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentGatewayRepo extends JpaRepository<PaymentGateway, Long> {

    PaymentGateway findPaymentGatewayById(Long id);
}
