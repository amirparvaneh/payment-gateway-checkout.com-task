package com.checkout.paymentgateway.service.impl;

import com.checkout.paymentgateway.dto.paymentGatewayDto.UpdatePaymentGatewayDto;
import com.checkout.paymentgateway.exception.PaymentException;
import com.checkout.paymentgateway.model.PaymentGateway;
import com.checkout.paymentgateway.repository.PaymentGatewayRepo;
import com.checkout.paymentgateway.service.PaymentGatewayService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentGatewayServiceImpl implements PaymentGatewayService {

    private final PaymentGatewayRepo paymentGatewayRepo;

    public PaymentGatewayServiceImpl(PaymentGatewayRepo paymentGatewayRepo){
        this.paymentGatewayRepo = paymentGatewayRepo;
    }

    @Override
    public void save(PaymentGateway paymentGateway) {
        paymentGatewayRepo.save(paymentGateway);
    }

    @Override
    public void delete(Long id) throws PaymentException {
        Optional<PaymentGateway> paymentGateway = Optional.ofNullable(paymentGatewayRepo.findPaymentGatewayById(id));
        if (paymentGateway.isPresent()){
            paymentGatewayRepo.delete(paymentGateway.get());
        }else
            throw new PaymentException("not fount");
    }

    @Override
    public void update(PaymentGateway paymentGateway) {
        paymentGatewayRepo.save(paymentGateway);
    }

    @Override
    public List<PaymentGateway> findAll() {
        List<PaymentGateway> paymentGateways = paymentGatewayRepo.findAll();
        return paymentGateways;
    }


    @Override
    public PaymentGateway findById(Long id) {
        return null;
    }

    public PaymentGateway updatePaymentByDto(Long id , UpdatePaymentGatewayDto updatePaymentGatewayDto){
       Optional<PaymentGateway> paymentGateway = Optional.ofNullable(paymentGatewayRepo.findPaymentGatewayById(id));
       if (paymentGateway.isPresent()){
           paymentGateway.get().setName(updatePaymentGatewayDto.getName());
           paymentGateway.get().setMerchantCapacity(updatePaymentGatewayDto.getMerchantCapacity());
           paymentGateway.get().setRequestCapacity(updatePaymentGatewayDto.getRequestCapacity());
       }
       return paymentGateway.orElse(null);

    }
}
