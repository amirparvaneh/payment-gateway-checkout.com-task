package com.checkout.paymentgateway.service;

import java.util.List;
import java.util.Optional;

public interface BaseService<T> {
    void save(T t);

    String delete(Long id);

    Optional<T> update(Long id, T t);

    List<T> findAll();

    void deleteById(Long id);

    T findById(Long id);
}
