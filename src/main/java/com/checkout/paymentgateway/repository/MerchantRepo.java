package com.checkout.paymentgateway.repository;

import com.checkout.paymentgateway.model.Merchant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MerchantRepo extends JpaRepository<Merchant, Long> , PagingAndSortingRepository<Merchant,Long> {
}
