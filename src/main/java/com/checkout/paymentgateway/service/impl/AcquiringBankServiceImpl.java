package com.checkout.paymentgateway.service.impl;

import com.checkout.paymentgateway.dto.bankDto.AcquiringBankUpdateDto;
import com.checkout.paymentgateway.exception.PaymentException;
import com.checkout.paymentgateway.model.AcquiringBank;
import com.checkout.paymentgateway.repository.AcquiringBankRepo;
import com.checkout.paymentgateway.service.AcquiringBankService;
import com.sun.jdi.LongValue;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AcquiringBankServiceImpl implements AcquiringBankService {

    private final AcquiringBankRepo acquiringBankRepo;

    public AcquiringBankServiceImpl(AcquiringBankRepo acquiringBankRepo) {
        this.acquiringBankRepo = acquiringBankRepo;
    }

    @Override
    public void save(AcquiringBank acquiringBank) {
        acquiringBankRepo.save(acquiringBank);
    }

    @Override
    public void delete(Long bankId) {
        acquiringBankRepo.deleteById(bankId);
    }

    @Override

    public void update(AcquiringBank acquiringBank) throws PaymentException {
        Optional<AcquiringBank> bank = acquiringBankRepo.findById(acquiringBank.getId());
        if (bank.isEmpty()) {
            throw new PaymentException("not found");
        }
        acquiringBankRepo.save(bank.get());
    }
    public void updateByDto(AcquiringBankUpdateDto acquiringBankUpdateDto) throws PaymentException {
        Optional<AcquiringBank> bank = acquiringBankRepo.findById(acquiringBankUpdateDto.getBankId());
        if (bank.isEmpty()) {
            throw new PaymentException("not found");
        }
        acquiringBankRepo.save(bank.get());
    }

    @Override
    public List<AcquiringBank> findAll() {
        return acquiringBankRepo.findAll();
    }


    @Override
    public AcquiringBank findById(Long bankId) throws PaymentException {
        Optional<AcquiringBank> acquiringBank = acquiringBankRepo.findById(bankId);
        if (acquiringBank.isEmpty()) {
            throw new PaymentException("not fount");
        }
        return acquiringBank.get();
    }

    public AcquiringBank findByName(String bankName) {
        return acquiringBankRepo.findAcquiringBankByName(bankName);
    }

    public Long accountNumberCreator(Long ownerId,Long bankCode){
        String accountNumber = ownerId.toString()  + "000" + bankCode.toString();
        return Long.parseLong(accountNumber);
    }
}
