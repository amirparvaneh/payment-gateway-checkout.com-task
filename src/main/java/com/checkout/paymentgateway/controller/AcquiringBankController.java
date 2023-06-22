package com.checkout.paymentgateway.controller;


import com.checkout.paymentgateway.model.AcquiringBank;
import com.checkout.paymentgateway.service.impl.AcquiringBankServiceImpl;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(name = "/bank")
public class AcquiringBankController {

    private final AcquiringBankServiceImpl acquiringBankService;

    public AcquiringBankController(AcquiringBankServiceImpl acquiringBankService){
        this.acquiringBankService = acquiringBankService;
    }

    @PostMapping
    public ResponseEntity<String> addNewAcquiringBank(@RequestBody AcquiringBank acquiringBank){
        acquiringBankService.save(acquiringBank);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    @ResponseBody
    public ResponseEntity<AcquiringBank> getAcquiringBankByName(@RequestParam String bankName){
        AcquiringBank acquiringBank = acquiringBankService.findByName(bankName);
        return ResponseEntity.ok(acquiringBank);
    }
}
