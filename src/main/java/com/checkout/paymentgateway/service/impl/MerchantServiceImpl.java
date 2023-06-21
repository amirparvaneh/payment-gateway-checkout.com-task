package com.checkout.paymentgateway.service.impl;

import com.checkout.paymentgateway.model.Merchant;
import com.checkout.paymentgateway.service.MerchantService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MerchantServiceImpl implements MerchantService {
    @Override
    public void save(Merchant merchant) {

    }

    @Override
    public String delete(Long id) {
        return null;
    }

    @Override
    public Optional<Merchant> update(Long id, Merchant merchant) {
        return Optional.empty();
    }

    @Override
    public List<Merchant> findAll() {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public Merchant findById(Long id) {
        return null;
    }
}
