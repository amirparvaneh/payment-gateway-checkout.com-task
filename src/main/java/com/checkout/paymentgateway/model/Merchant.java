package com.checkout.paymentgateway.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@Table(name = "merchant")
@NoArgsConstructor
@AllArgsConstructor
public class Merchant extends BaseEntity{

    private String name;
//    @OneToMany(mappedBy = "merchant")
//    private List<Order> orders;
//    @ManyToOne
//    @JoinColumn(name = "payment_gateway_id")
//    private PaymentGateway paymentGateway;

}