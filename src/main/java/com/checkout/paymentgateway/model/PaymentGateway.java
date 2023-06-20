package com.checkout.paymentgateway.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "payment-gateway")
@NoArgsConstructor
@AllArgsConstructor
public class PaymentGateway extends BaseEntity{
    private Long shopperId;
    private Merchant merchant;

}
