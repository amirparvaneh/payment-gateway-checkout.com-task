package com.checkout.paymentgateway.service.impl;

import com.checkout.paymentgateway.dto.ShopperUpdateDto;
import com.checkout.paymentgateway.exception.PaymentException;
import com.checkout.paymentgateway.model.Shopper;
import com.checkout.paymentgateway.repository.ShopperRepo;
import com.checkout.paymentgateway.service.ShopperService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ShopperServiceImpl implements ShopperService {

    private final ShopperRepo shopperRepo;


    public ShopperServiceImpl(ShopperRepo shopperRepo){
        this.shopperRepo = shopperRepo;
    }

    @Override
    public void save(Shopper shopper) {

    }

    @Override
    public String delete(Long id) {
        return null;
    }

    @Override
    public void update(Long id, Shopper shopper) {
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

    public Optional<Shopper> updateByDto(ShopperUpdateDto shopperUpdateDto) throws PaymentException {
        Optional<Shopper> shopper = shopperRepo.findById(shopperUpdateDto.getShopperId());
        if (shopper.isEmpty()){
            throw new PaymentException("not found");
        }
        shopper.get().setName(shopperUpdateDto.getName());
        shopperRepo.save(shopper.get());
        return Optional.empty();
    }
}
