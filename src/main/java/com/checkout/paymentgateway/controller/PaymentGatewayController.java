package com.checkout.paymentgateway.controller;

import com.checkout.paymentgateway.dto.PaymentGateWayNewDto;
import com.checkout.paymentgateway.exception.PaymentException;
import com.checkout.paymentgateway.model.PaymentGateway;
import com.checkout.paymentgateway.service.impl.PaymentGatewayServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(name = "/gateway")
public class PaymentGatewayController {

    private final PaymentGatewayServiceImpl paymentGatewayService;

    public PaymentGatewayController(PaymentGatewayServiceImpl paymentGatewayService){
        this.paymentGatewayService = paymentGatewayService;
    }


    @GetMapping
    public ResponseEntity<Optional<PaymentGateway>> getPaymentGatewayById(@RequestParam Long id) throws PaymentException {
        Optional<PaymentGateway> paymentGateway =Optional.ofNullable(paymentGatewayService.findById(id));
        if (paymentGateway.isEmpty()){
            throw new PaymentException("Not found");
        }
        return ResponseEntity.ok(paymentGateway);
    }

    @PostMapping
    public ResponseEntity<String> createNewPaymentGateway(@RequestBody PaymentGateWayNewDto paymentGateWayNewDto){
        PaymentGateway paymentGateway = PaymentGateway.builder()
                .name(paymentGateWayNewDto.getName())
                .merchantCapacity(paymentGateWayNewDto.getMerchantCapacity())
                .requestCapacity(paymentGateWayNewDto.getRequestCapacity())
                .build();
        paymentGatewayService.save(paymentGateway);
        return ResponseEntity.ok(paymentGateway.getName() + "created!");
    }
}
