package com.checkout.paymentgateway.repository;

import com.checkout.paymentgateway.model.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRepo extends JpaRepository<Card,Long> {
    Card findCardByCardNumber(Long cardNumber);
}
