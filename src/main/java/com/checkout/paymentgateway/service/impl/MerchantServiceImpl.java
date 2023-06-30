package com.checkout.paymentgateway.service.impl;

import com.checkout.paymentgateway.exception.PaymentException;
import com.checkout.paymentgateway.model.Merchant;
import com.checkout.paymentgateway.repository.MerchantRepo;
import com.checkout.paymentgateway.service.MerchantService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MerchantServiceImpl implements MerchantService {

    private final MerchantRepo merchantRepo;

    public MerchantServiceImpl(MerchantRepo merchantRepo){
        this.merchantRepo = merchantRepo;
    }
    @Override
    public void save(Merchant merchant) {
        merchantRepo.save(merchant);
    }

    @Override
    public void delete(Long merchantId) throws PaymentException {
        validateMerchantId(merchantId);
        merchantRepo.deleteById(merchantId);
    }

    @Override
    public void update(Merchant merchant) {

    }

    @Override
    public List<Merchant> findAll() {
        return null;
    }


    @Override
    public Merchant findById(Long id) {
        return null;
    }

    private void validateMerchantId(Long merchantId) throws PaymentException {
        Optional<Merchant> merchant = merchantRepo.findById(merchantId);
        if (merchant.isEmpty()){
            throw new PaymentException("not found");
        }

    }
}
