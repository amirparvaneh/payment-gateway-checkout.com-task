package com.checkout.paymentgateway.service.impl;

import com.checkout.paymentgateway.model.Shopper;
import com.checkout.paymentgateway.service.ShopperService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ShopperServiceImpl implements ShopperService {
    @Override
    public void save(Shopper shopper) {

    }

    @Override
    public String delete(Long id) {
        return null;
    }

    @Override
    public Optional<Shopper> update(Long id, Shopper shopper) {
        return Optional.empty();
    }

    @Override
    public List<Shopper> findAll() {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public Shopper findById(Long id) {
        return null;
    }
}
