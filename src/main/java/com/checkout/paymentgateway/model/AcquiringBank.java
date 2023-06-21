package com.checkout.paymentgateway.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@Table(name = "acquiring-bank")
@NoArgsConstructor
@AllArgsConstructor
public class AcquiringBank extends BaseEntity{

    private String name;
    private String bankCode;
    @ManyToOne
    @JoinColumn(name = "payment_gateway_id")
    private PaymentGateway paymentGateway;

}
