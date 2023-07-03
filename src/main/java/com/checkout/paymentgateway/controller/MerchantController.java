package com.checkout.paymentgateway.controller;


import com.checkout.paymentgateway.dto.merchantDto.MerchantNewDto;

import com.checkout.paymentgateway.exception.PaymentException;
import com.checkout.paymentgateway.model.Merchant;
import com.checkout.paymentgateway.model.PaymentGateway;
import com.checkout.paymentgateway.service.impl.MerchantServiceImpl;
import com.checkout.paymentgateway.service.impl.PaymentGatewayServiceImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping(value = "/merchant")
public class MerchantController {

    private final MerchantServiceImpl merchantService;
    private final PaymentGatewayServiceImpl paymentGatewayService;

    public MerchantController(MerchantServiceImpl merchantService, PaymentGatewayServiceImpl paymentGatewayService) {
        this.merchantService = merchantService;
        this.paymentGatewayService = paymentGatewayService;
    }

    @GetMapping
    public ResponseEntity<Merchant> getMerchantById(@RequestParam Long id) throws PaymentException {
        Optional<Merchant> merchant = Optional.ofNullable(merchantService.findById(id));
        if (merchant.isEmpty()) {
            throw new PaymentException("not found");
        }
        return ResponseEntity.ok(merchant.orElse(null));
    }


    @PostMapping
    public ResponseEntity<String> saveMerchant(@RequestBody MerchantNewDto merchantNewDto) {
        PaymentGateway paymentGateWay = paymentGatewayService.findById(merchantNewDto.getPaymentGatewayId());
        Merchant merchant = Merchant.builder()
                .name(merchantNewDto.getName())
                .paymentGateway(paymentGateWay)
                .build();
        return ResponseEntity.ok(merchant.getName() + "created!");
    }

    @GetMapping("/all")
    public ResponseEntity<Pageable> getAllMerchant(@RequestParam(defaultValue = "0") int pageNumber,
                                                   @RequestParam(defaultValue = "10") int pageSize) {
        Pageable merchants = PageRequest.of(pageNumber, pageSize);
        return ResponseEntity.ok(merchants);
    }

    @PutMapping
    public ResponseEntity<String> updateMerchant(@RequestParam Long id,
                                                 @RequestParam String name) throws PaymentException {
        Optional<Merchant> merchant = Optional.ofNullable(merchantService.findById(id));
        if (merchant.isEmpty()){
            throw new PaymentException("not fount");
        }
        merchant.get().setName(name);
        return ResponseEntity.ok(merchant.get().getName() + "updated ! ");
    }

    @DeleteMapping
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    public ResponseEntity<String> deleteMerchant(@RequestParam Long id) throws PaymentException {
        Optional<Merchant> merchant = Optional.ofNullable(merchantService.findById(id));
        if (merchant.isPresent()){
            merchantService.delete(id);
        }
        return ResponseEntity.ok("deleted");
    }


    @PostMapping("/create/account/onbank")
    public ResponseEntity<Account> createAccountOnBank(Account)

}









