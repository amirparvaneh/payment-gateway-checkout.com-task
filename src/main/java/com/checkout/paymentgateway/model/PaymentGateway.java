package com.checkout.paymentgateway.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@Table(name = "paymentGateway")
@NoArgsConstructor
@AllArgsConstructor
public class PaymentGateway extends BaseEntity{
    private String name;
    @OneToMany(mappedBy = "paymentGateway")
    private List<Request> requests;
    @OneToMany(mappedBy = "paymentGateway")
    private List<Merchant> merchants;
    @OneToMany(mappedBy = "paymentGateway")
    private List<Shopper> shoppers;
    @OneToMany(mappedBy = "paymentGateway")
    private List<AcquiringBank> acquiringBanks;
}