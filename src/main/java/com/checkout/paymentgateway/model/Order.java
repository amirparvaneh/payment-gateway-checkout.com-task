package com.checkout.paymentgateway.model;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "order")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Order extends BaseEntity {

    private String product;
    private String description;
    private Long price;
    @ManyToOne
    @JoinColumn(name = "shopper_id")
    private Shopper shopper;
    @ManyToOne
    @JoinColumn(name = "merchant_id")
    private Merchant merchant;

}
