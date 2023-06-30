package com.checkout.paymentgateway.service.impl;

import com.checkout.paymentgateway.exception.PaymentException;
import com.checkout.paymentgateway.model.Request;
import com.checkout.paymentgateway.repository.RequestRepo;
import com.checkout.paymentgateway.service.RequestService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RequestServiceImpl implements RequestService {

    private final RequestRepo requestRepo;


    public RequestServiceImpl(RequestRepo requestRepo) {
        this.requestRepo = requestRepo;
    }

    @Override
    public void save(Request request) {
        requestRepo.save(request);
    }

    @Override
    public void delete(Long requestId) throws PaymentException {
        validateRequestId(requestId);
        requestRepo.deleteById(requestId);
    }

    @Override
    public void update(Request requestUpdateDto) {
        Optional<Request> request = requestRepo.findById(requestUpdateDto.getRequestId());

    }

    @Override
    public List<Request> findAll() {
        return requestRepo.findAll();
    }


    @Override
    public Request findById(Long requestId) throws PaymentException {
        validateRequestId(requestId);
        Optional<Request> request = requestRepo.findById(requestId);
        return request.get();
    }

    public Request findShoppersRequest(Long shopperId) throws PaymentException {
        Optional<Request> request = Optional.ofNullable(requestRepo.findRequestByShopper(shopperId));
        if (request.isEmpty()) {
            throw new PaymentException("there is no request with this shopperID");
        }
        return request.get();
    }

    private void validateRequestId(Long requestId) throws PaymentException {
        Optional<Request> request = requestRepo.findById(requestId);
        if (request.isEmpty()){
            throw new PaymentException("not found");
        }
    }
}
