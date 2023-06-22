package com.checkout.paymentgateway.repository;

import com.checkout.paymentgateway.model.Request;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RequestRepo extends JpaRepository<Request, Long> {
}
