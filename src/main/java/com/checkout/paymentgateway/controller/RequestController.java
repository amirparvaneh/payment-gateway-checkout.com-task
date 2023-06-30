package com.checkout.paymentgateway.controller;


import com.checkout.paymentgateway.dto.requestDto.RequestCreationDto;
import com.checkout.paymentgateway.exception.PaymentException;
import com.checkout.paymentgateway.model.Merchant;
import com.checkout.paymentgateway.model.PaymentGateway;
import com.checkout.paymentgateway.model.Request;
import com.checkout.paymentgateway.model.Shopper;
import com.checkout.paymentgateway.service.impl.MerchantServiceImpl;
import com.checkout.paymentgateway.service.impl.PaymentGatewayServiceImpl;
import com.checkout.paymentgateway.service.impl.RequestServiceImpl;
import com.checkout.paymentgateway.service.impl.ShopperServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value = "/order")
public class RequestController {

    private final RequestServiceImpl requestService;
    private final PaymentGatewayServiceImpl paymentGatewayService;
    private final ShopperServiceImpl shopperService;
    private final MerchantServiceImpl merchantService;

    public RequestController(RequestServiceImpl requestService,
                             PaymentGatewayServiceImpl paymentGatewayService,
                             ShopperServiceImpl shopperService,
                             MerchantServiceImpl merchantService){
        this.requestService = requestService;
        this.merchantService = merchantService;
        this.shopperService = shopperService;
        this.paymentGatewayService = paymentGatewayService;
    }

    @PostMapping
    public ResponseEntity<Request> makeNewRequestByShopper(@RequestBody RequestCreationDto requestCreationDto){
        PaymentGateway paymentGateway = paymentGatewayService.findById(requestCreationDto.getPaymentGatewayId());
        Shopper shopper = shopperService.findById(requestCreationDto.getShopperId());
        Merchant merchant = merchantService.findById(requestCreationDto.getMerchantId());
        Request request = Request.builder()
                .price(requestCreationDto.getAmount())
                .paymentGateway(paymentGateway)
                .shopper(shopper)
                .merchant(merchant)
                .build();
        requestService.save(request);
        return ResponseEntity.ok(request);
    }

    @GetMapping
    public ResponseEntity<Request> getRequest(@RequestParam Long requestId){
        Optional<Request> request = Optional.ofNullable(requestService.findById(requestId));
        return ResponseEntity.ok(request.orElse(null));
    }


    @GetMapping("/shopperId")
    public ResponseEntity<Request> getRequestByShopperId(@RequestParam Long shopperId) throws PaymentException {
        Optional<Request> shopperRequest = Optional.ofNullable(requestService.findShoppersRequest(shopperId));
        return ResponseEntity.ok(shopperRequest.orElse(null));
    }

    @DeleteMapping
    public ResponseEntity<String> deleteRequest(@RequestParam Long requestId){
        requestService.delete(requestId);
        return ResponseEntity.ok("deleted!");
    }

}
