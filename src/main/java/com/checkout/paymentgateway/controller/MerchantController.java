package com.checkout.paymentgateway.controller;


import com.checkout.paymentgateway.dto.merchantDto.MerchantAccountNewDto;
import com.checkout.paymentgateway.dto.merchantDto.MerchantNewDto;

import com.checkout.paymentgateway.dto.paymentGatewayDto.PaymentRequestDto;
import com.checkout.paymentgateway.dto.paymentGatewayDto.PaymentResponseDto;
import com.checkout.paymentgateway.exception.PaymentException;
import com.checkout.paymentgateway.model.Account;
import com.checkout.paymentgateway.model.Merchant;
import com.checkout.paymentgateway.model.PaymentGateway;
import com.checkout.paymentgateway.model.Request;
import com.checkout.paymentgateway.service.impl.AcquiringBankServiceImpl;
import com.checkout.paymentgateway.service.impl.MerchantServiceImpl;
import com.checkout.paymentgateway.service.impl.PaymentGatewayServiceImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping(value = "/merchant")
public class MerchantController {

    private final MerchantServiceImpl merchantService;
    private final PaymentGatewayServiceImpl paymentGatewayService;
    private final AcquiringBankServiceImpl acquiringBankService;

    public MerchantController(MerchantServiceImpl merchantService, PaymentGatewayServiceImpl paymentGatewayService
    ,AcquiringBankServiceImpl acquiringBankService) {
        this.merchantService = merchantService;
        this.paymentGatewayService = paymentGatewayService;
        this.acquiringBankService = acquiringBankService;
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
    public ResponseEntity<String> saveMerchant(@RequestBody MerchantNewDto merchantNewDto) throws PaymentException {
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
    public ResponseEntity<Account> createAccountOnBank(@RequestParam MerchantAccountNewDto merchantAccountNewDto){
        merchantAccountNewDto.setAccountNumber(acquiringBankService.accountNumberCreator(merchantAccountNewDto.getMerchantId(),
                merchantAccountNewDto.getBankCode()));
        Account account = merchantService.createAccount(merchantAccountNewDto);
        return ResponseEntity.ok(account);
    }

    @GetMapping("/shopper/requests")
    public List<Request> getShopperRequest(){
        merchantService.getShopperRequest()
    }

    @PostMapping("/payment/request")
    public PaymentResponseDto processPayment(@RequestParam PaymentRequestDto paymentRequestDto){
        PaymentResponseDto paymentResponseDto = merchantService.sendRequestToPG(paymentRequestDto);
        return
    }

    @GetMapping("/retrieve/payment")
    public PaymentResponseDto retrievePayment(@RequestParam Long paymentId){

    }

}









