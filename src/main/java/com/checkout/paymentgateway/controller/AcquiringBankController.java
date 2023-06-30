package com.checkout.paymentgateway.controller;


import com.checkout.paymentgateway.dto.AcquiringBankNewDto;
import com.checkout.paymentgateway.exception.PaymentException;
import com.checkout.paymentgateway.model.AcquiringBank;
import com.checkout.paymentgateway.service.impl.AcquiringBankServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping(value = "/bank")
public class AcquiringBankController {

    private final AcquiringBankServiceImpl acquiringBankService;

    public AcquiringBankController(AcquiringBankServiceImpl acquiringBankService) {
        this.acquiringBankService = acquiringBankService;
    }

    @PostMapping
    public ResponseEntity<String> addNewAcquiringBank(@RequestBody AcquiringBankNewDto acquiringBank) {
        AcquiringBank newOne = AcquiringBank.builder()
                .name(acquiringBank.getName())
                .bankCode(acquiringBank.getBankCode())
                .build();
        acquiringBankService.save(newOne);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    @ResponseBody
    public ResponseEntity<AcquiringBank> getAcquiringBankByName(@RequestParam String bankName) {
        AcquiringBank acquiringBank = acquiringBankService.findByName(bankName);
        return ResponseEntity.ok(acquiringBank);
    }

    @GetMapping("/all")
    public ResponseEntity<List<AcquiringBank>> getAllBank() {
        List<AcquiringBank> acquiringBanks = acquiringBankService.findAll();
        return ResponseEntity.ok(acquiringBanks);
    }

    @PutMapping
    public ResponseEntity<String> updateBankName(@RequestParam Long id, @RequestParam String bankName) throws PaymentException {
        AcquiringBank acquiringBank = acquiringBankService.findById(id);
        if (Objects.nonNull(acquiringBank)) {
            acquiringBank.setName(bankName);
            acquiringBankService.update(acquiringBank);
        }
        return ResponseEntity.ok("bank" + id + "have been updated to : " + bankName);
    }

    @DeleteMapping
    public ResponseEntity<String> deleteBankById(@RequestParam Long bankId){
        acquiringBankService.delete(bankId);
        return ResponseEntity.ok("bank with id : " + bankId + "deleted ! ");
    }
}
