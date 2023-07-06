package com.checkout.paymentgateway.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@Table(name = "merchant")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Merchant extends BaseEntity{

    private String name;

    @OneToMany(mappedBy = "merchant")
    private List<Request> requests;
    @ManyToOne
    @JoinColumn(name = "payment_gateway_id")
    private PaymentGateway paymentGateway;

    private Long accountNumber;

    private String product;
}
