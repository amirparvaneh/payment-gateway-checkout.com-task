package com.checkout.paymentgateway.service.impl;

import com.checkout.paymentgateway.dto.merchantDto.MerchantAccountNewDto;
import com.checkout.paymentgateway.dto.paymentGatewayDto.PaymentRequestDto;
import com.checkout.paymentgateway.dto.paymentGatewayDto.PaymentResponseDto;
import com.checkout.paymentgateway.exception.PaymentException;
import com.checkout.paymentgateway.model.*;
import com.checkout.paymentgateway.repository.AccountRepo;
import com.checkout.paymentgateway.repository.MerchantRepo;
import com.checkout.paymentgateway.repository.PaymentRepo;
import com.checkout.paymentgateway.service.MerchantService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MerchantServiceImpl implements MerchantService {

    private final MerchantRepo merchantRepo;
    private final AccountRepo accountRepo;
    private final PaymentService paymentService;
    private final PaymentGatewayServiceImpl paymentGatewayService;
    private final CardServiceImpl cardService;
    private final RequestServiceImpl requestService;

    public MerchantServiceImpl(MerchantRepo merchantRepo, AccountRepo accountRepo,PaymentService paymentService,
                               PaymentGatewayServiceImpl paymentGatewayService,
                               CardServiceImpl cardService,
                               RequestServiceImpl requestService){
        this.merchantRepo = merchantRepo;
        this.accountRepo = accountRepo;
        this.paymentService = paymentService;
        this.paymentGatewayService = paymentGatewayService;
        this.cardService = cardService;
        this.requestService = requestService;
    }
    @Override
    public void save(Merchant merchant) {
        merchantRepo.save(merchant);
    }

    @Override
    public void delete(Long merchantId) throws PaymentException {
        validateMerchantId(merchantId);
        merchantRepo.deleteById(merchantId);
    }

    @Override
    public void update(Merchant merchant) {

    }

    @Override
    public List<Merchant> findAll() {
        return null;
    }


    @Override
    public Merchant findById(Long id) {
        return null;
    }

    private void validateMerchantId(Long merchantId) throws PaymentException {
        Optional<Merchant> merchant = merchantRepo.findById(merchantId);
        if (merchant.isEmpty()){
            throw new PaymentException("not found");
        }

    }

    public Account createAccount(MerchantAccountNewDto merchantAccountNewDto){
        Account account =  Account.builder()
                .ownerId(merchantAccountNewDto.getMerchantId())
                .accountNumber(merchantAccountNewDto.getAccountNumber())
                .build();
        accountRepo.save(account);
        return account;
    }

    public List<Request> getShopperRequest(){

    }

    public PaymentResponseDto submitRequestToPG(PaymentRequestDto paymentRequestDto) throws PaymentException {
        PaymentGateway paymentGateway = paymentGatewayService.findById(paymentRequestDto.getPaymentGatewayId());
        Card card = cardService.findById(paymentRequestDto.getCardId());
        Request request = requestService.findById(paymentRequestDto.getRequestId());


    }

    public PaymentResponseDto retrievePaymentById(Long paymentId){

    }
}
