package com.checkout.paymentgateway.service.impl;

import com.checkout.paymentgateway.dto.buy.BuyingRequestDto;
import com.checkout.paymentgateway.dto.buy.BuyingResponseDto;
import com.checkout.paymentgateway.dto.shopperDto.ShopperAccountNewDto;
import com.checkout.paymentgateway.dto.shopperDto.ShopperUpdateDto;
import com.checkout.paymentgateway.exception.PaymentException;
import com.checkout.paymentgateway.model.Account;
import com.checkout.paymentgateway.model.PaymentGateway;
import com.checkout.paymentgateway.model.Shopper;
import com.checkout.paymentgateway.repository.AccountRepo;
import com.checkout.paymentgateway.repository.ShopperRepo;
import com.checkout.paymentgateway.service.ShopperService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ShopperServiceImpl implements ShopperService {

    private final ShopperRepo shopperRepo;
    private final PaymentGatewayServiceImpl paymentGatewayService;
    private final AccountRepo accountRepo;


    public ShopperServiceImpl(ShopperRepo shopperRepo, PaymentGatewayServiceImpl paymentGatewayService,
                              AccountRepo accountRepo) {
        this.shopperRepo = shopperRepo;
        this.paymentGatewayService = paymentGatewayService;
        this.accountRepo = accountRepo;
    }

    @Override
    public void save(Shopper shopper) {
        shopperRepo.save(shopper);
    }

    @Override
    public void delete(Long shopperId) {
        shopperRepo.deleteById(shopperId);
    }

    @Override
    public void update(Shopper shopper) throws PaymentException {
        validateShopper(shopper.getId());
        shopperRepo.save(shopper);
    }

    @Override
    public List<Shopper> findAll() {
        return null;
    }

    @Override
    public Shopper findById(Long id) {
        return null;
    }

    public Optional<Shopper> updateByDto(ShopperUpdateDto shopperUpdateDto) throws PaymentException {
        Optional<Shopper> shopper = shopperRepo.findById(shopperUpdateDto.getShopperId());
        if (shopper.isEmpty()) {
            throw new PaymentException("not found");
        }
        shopper.get().setName(shopperUpdateDto.getName());
        shopperRepo.save(shopper.get());
        return Optional.empty();
    }

    private void validateShopper(Long shopperId) throws PaymentException {
        Optional<Shopper> shopper = shopperRepo.findById(shopperId);
        if (shopper.isEmpty()){
            throw new PaymentException("there is no shopper with this id");
        }
    }

    public Account saveAccount(ShopperAccountNewDto shopperAccountNewDto){
        Account account = Account.builder()
                .accountNumber(shopperAccountNewDto.getAccountNumber())
                .ownerId(shopperAccountNewDto.getShopperId())
                .balance(shopperAccountNewDto.getSettleDeposit())
                .build();
        accountRepo.save(account);
        return account;
    }

    public BuyingResponseDto buy(BuyingRequestDto buyingRequestDto){
        //todo send this request to the payment gateway and then validate payment
        // and send this again and check with merchant product request
        PaymentGateway paymentGateway = paymentGatewayService.findById(buyingRequestDto.getPaymentGateway());

    }
}
