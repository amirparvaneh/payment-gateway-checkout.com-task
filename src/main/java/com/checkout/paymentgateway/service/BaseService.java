package com.checkout.paymentgateway.service;

import com.checkout.paymentgateway.exception.PaymentException;

import java.util.List;

public interface BaseService<T> {
    void save(T t);

    void delete(Long id) throws PaymentException;

    void update(T t) throws PaymentException;

    List<T> findAll();

    T findById(Long id) throws PaymentException;
}
