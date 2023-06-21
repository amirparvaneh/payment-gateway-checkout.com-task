package com.checkout.paymentgateway.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@Table(name = "payment-gateway")
@NoArgsConstructor
@AllArgsConstructor
public class PaymentGateway extends BaseEntity{

    @OneToMany(mappedBy = "paymentGateway")
    private List<Order> orders;
    @OneToMany(mappedBy = "paymentGateway")
    private List<Merchant> merchants;
    @OneToMany(mappedBy = "paymentGateway")
    private List<Shopper> shoppers;
    @OneToMany
    private List<AcquiringBank> acquiringBanks;

}
