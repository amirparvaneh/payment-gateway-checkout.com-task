package com.checkout.paymentgateway.controller;

import com.checkout.paymentgateway.dto.PaymentGateWayNewDto;
import com.checkout.paymentgateway.dto.UpdatePaymentGatewayDto;
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

    @PutMapping
    public ResponseEntity<String> updatePaymentGateway(@RequestParam Long id,
                                                       @RequestBody UpdatePaymentGatewayDto updatePaymentGatewayDto){

      paymentGatewayService.updatePaymentByDto(id,updatePaymentGatewayDto);
      return ResponseEntity.ok("payment gateway with this id : " +"id " + " updated!" );
    }

    @DeleteMapping
    public ResponseEntity<String> deletePaymentGateway(@RequestParam Long paymentGatewayId) throws PaymentException {
        paymentGatewayService.delete(paymentGatewayId);
        return ResponseEntity.ok("deleted");
    }
}
