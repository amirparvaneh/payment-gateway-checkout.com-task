package com.checkout.paymentgateway.service.impl;

import com.checkout.paymentgateway.dto.buy.BuyingRequestDto;
import com.checkout.paymentgateway.dto.buy.BuyingResponseDto;
import com.checkout.paymentgateway.dto.shopperDto.ShopperAccountNewDto;
import com.checkout.paymentgateway.dto.shopperDto.ShopperUpdateDto;
import com.checkout.paymentgateway.exception.PaymentException;
import com.checkout.paymentgateway.model.*;
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
    private final MerchantServiceImpl merchantService;


    public ShopperServiceImpl(ShopperRepo shopperRepo, PaymentGatewayServiceImpl paymentGatewayService,
                              AccountRepo accountRepo,
                              MerchantServiceImpl merchantService) {
        this.shopperRepo = shopperRepo;
        this.paymentGatewayService = paymentGatewayService;
        this.accountRepo = accountRepo;
        this.merchantService = merchantService;
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
    public Shopper findById(Long shopperId) throws PaymentException {
         Optional<Shopper> shopper= shopperRepo.findById(shopperId);
         if (shopper.isEmpty()){
             throw new PaymentException("not found");
         }
         return shopper.get();
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

    public Request buy(BuyingRequestDto buyingRequestDto) throws PaymentException {
        Merchant merchant = merchantService.findById(buyingRequestDto.getMerchantId());
        Shopper shopper = findById(buyingRequestDto.getShopperId());
        Request request = Request.builder()
                .shopper(shopper)
                .merchant(merchant)
                .price(buyingRequestDto.getPrice())
                .description(buyingRequestDto.getDescription())
                .product(buyingRequestDto.getProduct())
                .build();
        return request;
    }
}
