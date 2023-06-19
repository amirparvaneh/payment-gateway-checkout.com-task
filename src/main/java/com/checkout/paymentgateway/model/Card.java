package com.checkout.paymentgateway.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "card")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Card extends BaseEntity{
    private String cvv;
    private Long shopperId;
}
