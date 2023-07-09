package com.checkout.paymentgateway.service.impl;

import com.checkout.paymentgateway.dto.buy.BuyingResponseDto;
import com.checkout.paymentgateway.dto.merchantDto.MerchantCallRequestDto;
import com.checkout.paymentgateway.dto.payment.PaymentDto;
import com.checkout.paymentgateway.dto.paymentGatewayDto.PaymentResponseDto;
import com.checkout.paymentgateway.dto.paymentGatewayDto.UpdatePaymentGatewayDto;
import com.checkout.paymentgateway.dto.requestDto.RequestValidateDto;
import com.checkout.paymentgateway.exception.PaymentException;
import com.checkout.paymentgateway.model.*;
import com.checkout.paymentgateway.repository.AccountRepo;
import com.checkout.paymentgateway.repository.PaymentGatewayRepo;
import com.checkout.paymentgateway.service.PaymentGatewayService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentGatewayServiceImpl implements PaymentGatewayService {

    private final PaymentGatewayRepo paymentGatewayRepo;
    private final PaymentService paymentService;
    private final AccountServiceImpl accountService;

    public PaymentGatewayServiceImpl(PaymentGatewayRepo paymentGatewayRepo,
                                     PaymentService paymentService,
                                     AccountServiceImpl accountService) {
        this.paymentGatewayRepo = paymentGatewayRepo;
        this.paymentService = paymentService;
        this.accountService = accountService;
    }

    @Override
    public void save(PaymentGateway paymentGateway) {
        paymentGatewayRepo.save(paymentGateway);
    }

    @Override
    public void delete(Long id) throws PaymentException {
        Optional<PaymentGateway> paymentGateway = Optional.ofNullable(paymentGatewayRepo.findPaymentGatewayById(id));
        if (paymentGateway.isPresent()) {
            paymentGatewayRepo.delete(paymentGateway.get());
        } else
            throw new PaymentException("not fount");
    }

    @Override
    public void update(PaymentGateway paymentGateway) {
        paymentGatewayRepo.save(paymentGateway);
    }

    @Override
    public List<PaymentGateway> findAll() {
        List<PaymentGateway> paymentGateways = paymentGatewayRepo.findAll();
        return paymentGateways;
    }


    @Override
    public PaymentGateway findById(Long paymentGatewayId) throws PaymentException {
        Optional<PaymentGateway> paymentGateway = paymentGatewayRepo.findById(paymentGatewayId);
        if (paymentGateway.isEmpty()) {
            throw new PaymentException("not found");
        }
        return paymentGateway.get();
    }

    public PaymentGateway updatePaymentByDto(Long id, UpdatePaymentGatewayDto updatePaymentGatewayDto) {
        Optional<PaymentGateway> paymentGateway = Optional.ofNullable(paymentGatewayRepo.findPaymentGatewayById(id));
        if (paymentGateway.isPresent()) {
            paymentGateway.get().setName(updatePaymentGatewayDto.getName());
            paymentGateway.get().setMerchantCapacity(updatePaymentGatewayDto.getMerchantCapacity());
            paymentGateway.get().setRequestCapacity(updatePaymentGatewayDto.getRequestCapacity());
        }
        return paymentGateway.orElse(null);

    }

    public PaymentResponseDto pay(MerchantCallRequestDto merchantCallRequestDto) throws PaymentException {
        Account merchantAccount = accountService.findAccountByMerchantId(merchantCallRequestDto.getMerchantId());
        PaymentDto paymentDto = PaymentDto.builder()
                .accountNumber(merchantAccount.getAccountNumber())
                .amount(merchantCallRequestDto.getAmount())
                .build();
        PaymentResponseDto responseDto = paymentService.createPayment(paymentDto);

    }

    public void sendPaymentResponseToMerchant() {

    }

    public void validateRequest(RequestValidateDto requestValidateDto) {

    }

    public void storingCardInformation(Card card) {

    }
}
