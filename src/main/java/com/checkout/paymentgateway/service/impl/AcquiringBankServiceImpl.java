package com.checkout.paymentgateway.service.impl;

import com.checkout.paymentgateway.model.AcquiringBank;
import com.checkout.paymentgateway.service.AcquiringBankService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AcquiringBankServiceImpl implements AcquiringBankService {
    @Override
    public void save(AcquiringBank acquiringBank) {

    }

    @Override
    public String delete(Long id) {
        return null;
    }

    @Override
    public Optional<AcquiringBank> update(Long id, AcquiringBank acquiringBank) {
        return Optional.empty();
    }

    @Override
    public List<AcquiringBank> findAll() {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public AcquiringBank findById(Long id) {
        return null;
    }
}
