package com.checkout.paymentgateway.controller;


import com.checkout.paymentgateway.dto.buy.BuyingRequestDto;
import com.checkout.paymentgateway.dto.buy.BuyingResponseDto;
import com.checkout.paymentgateway.dto.shopperDto.ShopperAccountNewDto;
import com.checkout.paymentgateway.dto.shopperDto.ShopperNewDto;
import com.checkout.paymentgateway.dto.shopperDto.ShopperUpdateDto;
import com.checkout.paymentgateway.exception.PaymentException;
import com.checkout.paymentgateway.model.Account;
import com.checkout.paymentgateway.model.Card;
import com.checkout.paymentgateway.model.Shopper;
import com.checkout.paymentgateway.service.impl.CardServiceImpl;
import com.checkout.paymentgateway.service.impl.ShopperServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping(value = "/shopper")
public class ShopperController {

    private final ShopperServiceImpl shopperService;
    private final CardServiceImpl cardService;

    public ShopperController(ShopperServiceImpl shopperService, CardServiceImpl cardService) {
        this.shopperService = shopperService;
        this.cardService = cardService;
    }


    @PostMapping
    public ResponseEntity<String> saveNewShopper(@RequestBody ShopperNewDto shopperNewDto) {
        List<Card> shopperCardList = new ArrayList<>();
        Optional<Card> card = Optional.ofNullable(cardService.findCardByCardNumber(shopperNewDto.getCardNumber()));
        card.ifPresent(shopperCardList::add);
        Shopper shopper = Shopper.builder()
                .name(shopperNewDto.getBankName())
                .card(shopperCardList)
                .build();
        return ResponseEntity.ok("the shopper : " + shopper.getName() + "added !");
    }

    @GetMapping
    public ResponseEntity<Shopper> getShopperById(@RequestParam Long shopperId) {
        Optional<Shopper> shopper = Optional.ofNullable(shopperService.findById(shopperId));
        return ResponseEntity.ok(shopper.orElse(null));
    }

    @GetMapping("/all")
    public ResponseEntity<List<Shopper>> getAllShopper() throws PaymentException {
        List<Shopper> resultShopperList = shopperService.findAll();
        if (Objects.isNull(resultShopperList)) {
            throw new PaymentException("there is no shopper now!");
        }
        return ResponseEntity.ok(resultShopperList);
    }

    @PutMapping
    public ResponseEntity<String> updateShopper(@RequestBody ShopperUpdateDto shopperUpdateDto) throws PaymentException {
        shopperService.updateByDto(shopperUpdateDto);
        return ResponseEntity.ok("update!");
    }

    @DeleteMapping
    public ResponseEntity<String> deleteShopper(@RequestParam Long id) {
        shopperService.delete(id);
        return ResponseEntity.ok("shopper id : " + "deleted!");
    }

    @PostMapping("/buy")
    public ResponseEntity<BuyingResponseDto> buyingProduct(@RequestParam BuyingRequestDto buyingRequestDto){
        BuyingResponseDto buyResult = shopperService.buy(buyingRequestDto);
        return ResponseEntity.ok(buyResult);
    }

    @PostMapping("/create/account")
    public ResponseEntity<Account> createShopperAccount(@RequestParam ShopperAccountNewDto shopperAccountNewDto){
        Account account = Account.builder()
                .accountNumber(shopperAccountNewDto.getCardNumber())
                .build();
        return ResponseEntity.ok(account);
    }

    
}
