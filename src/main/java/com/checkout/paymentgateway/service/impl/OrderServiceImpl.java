package com.checkout.paymentgateway.service.impl;

import com.checkout.paymentgateway.model.Order;
import com.checkout.paymentgateway.service.OrderService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {
    @Override
    public void save(Order order) {

    }

    @Override
    public String delete(Long id) {
        return null;
    }

    @Override
    public Optional<Order> update(Long id, Order order) {
        return Optional.empty();
    }

    @Override
    public List<Order> findAll() {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public Order findById(Long id) {
        return null;
    }
}
