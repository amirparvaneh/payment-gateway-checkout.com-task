package com.checkout.paymentgateway.service.impl;

import com.checkout.paymentgateway.dto.shopperDto.ShopperUpdateDto;
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


    public ShopperServiceImpl(ShopperRepo shopperRepo) {
        this.shopperRepo = shopperRepo;
    }

    @Override
    public void save(Shopper shopper) {
        shopperRepo.save(shopper);

    }

    @Override
    public void delete(Long id) {
    }

    @Override
    public void update(Shopper shopper) {
    }

    @Override
    public List<Shopper> findAll() {
        return null;
    }

    @Override
    public Shopper findById(Long id) {
        return null;
    }

    public Optional<Shopper> updateByDto(ShopperUpdateDto shopperUpdateDto) throws PaymentException {
        Optional<Shopper> shopper = shopperRepo.findById(shopperUpdateDto.getShopperId());
        if (shopper.isEmpty()) {
            throw new PaymentException("not found");
        }
        shopper.get().setName(shopperUpdateDto.getName());
        shopperRepo.save(shopper.get());
        return Optional.empty();
    }
}
