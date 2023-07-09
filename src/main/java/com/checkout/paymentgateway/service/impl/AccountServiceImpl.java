package com.checkout.paymentgateway.service.impl;

import com.checkout.paymentgateway.exception.PaymentException;
import com.checkout.paymentgateway.model.Account;
import com.checkout.paymentgateway.repository.AccountRepo;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountServiceImpl {

    private final AccountRepo accountRepo;

    public AccountServiceImpl(AccountRepo accountRepo){
        this.accountRepo = accountRepo;
    }


    public Account findAccountByMerchantId(Long merchantId) throws PaymentException {
        Optional<Account> account = accountRepo.findById(merchantId);
        if (account.isEmpty()){
            throw new PaymentException("not such account for this merchant !");
        }
        return account.get();
    }
}
