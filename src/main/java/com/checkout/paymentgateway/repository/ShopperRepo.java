package com.checkout.paymentgateway.repository;

import com.checkout.paymentgateway.model.Shopper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShopperRepo extends JpaRepository<Shopper, Long> {
}
