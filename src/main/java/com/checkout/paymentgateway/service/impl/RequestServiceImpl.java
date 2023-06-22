package com.checkout.paymentgateway.service.impl;

import com.checkout.paymentgateway.model.Request;
import com.checkout.paymentgateway.service.RequestService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RequestServiceImpl implements RequestService {

    @Override
    public void save(Request request) {

    }

    @Override
    public String delete(Long id) {
        return null;
    }

    @Override
    public Optional<Request> update(Long id, Request request) {
        return Optional.empty();
    }

    @Override
    public List<Request> findAll() {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public Request findById(Long id) {
        return null;
    }
}
