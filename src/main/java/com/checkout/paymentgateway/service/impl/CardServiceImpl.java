package com.checkout.paymentgateway.service.impl;

import com.checkout.paymentgateway.model.Card;
import com.checkout.paymentgateway.repository.CardRepo;
import com.checkout.paymentgateway.service.CardService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardServiceImpl implements CardService {

    private final CardRepo cardRepo;

    public CardServiceImpl(CardRepo cardRepo) {
        this.cardRepo = cardRepo;
    }

    @Override
    public void save(Card card) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public void update(Card card) {

    }

    @Override
    public List<Card> findAll() {
        return null;
    }


    @Override
    public Card findById(Long id) {
        return null;
    }


    public Card findCardByCardNumber(Long cardNumber) {
        return cardRepo.findCardByCardNumber(cardNumber);
    }
}
