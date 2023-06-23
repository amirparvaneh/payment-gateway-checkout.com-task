package com.checkout.paymentgateway.controller;


import com.checkout.paymentgateway.service.impl.MerchantServiceImpl;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping(name = "/merchant")
public class MerchantController {

    private final MerchantServiceImpl merchantService;

    public MerchantController(MerchantServiceImpl merchantService){
        this.merchantService = merchantService;
    }


}
