package com.checkout.paymentgateway.repository;

import com.checkout.paymentgateway.model.AcquiringBank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AcquiringBankRepo extends JpaRepository<AcquiringBank, Long> {
    AcquiringBank findAcquiringBankByName(String bankName);
}
