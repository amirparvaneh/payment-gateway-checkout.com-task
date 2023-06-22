package com.checkout.paymentgateway.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@Table(name = "shopper")
@NoArgsConstructor
@AllArgsConstructor
public class Shopper extends BaseEntity{

    private String name;
    @OneToMany(mappedBy = "shopper")
    private List<Card> card;
    @OneToMany(mappedBy = "shopper")
    private List<Request> requests;
    @ManyToOne
    @JoinColumn(name = "payment_gateway_id")
    private PaymentGateway paymentGateway;
}
