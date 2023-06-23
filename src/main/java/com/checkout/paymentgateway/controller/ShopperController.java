package com.checkout.paymentgateway.controller;


import com.checkout.paymentgateway.dto.ShopperNewDto;
import com.checkout.paymentgateway.model.Card;
import com.checkout.paymentgateway.model.Shopper;
import com.checkout.paymentgateway.service.impl.CardServiceImpl;
import com.checkout.paymentgateway.service.impl.ShopperServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(name = "/shopper")
public class ShopperController {

    private final ShopperServiceImpl shopperService;
    private final CardServiceImpl cardService;

    public ShopperController(ShopperServiceImpl shopperService, CardServiceImpl cardService) {
        this.shopperService = shopperService;
        this.cardService = cardService;
    }


    @GetMapping
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
}
