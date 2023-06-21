package com.checkout.paymentgateway.model;


import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
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

}
