package com.checkout.paymentgateway.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Entity
@Table(name = "account")
@AllArgsConstructor
@Data
@Builder
public class Account extends BaseEntity {
    private Long accountNumber;
    private Long balance;
    private Long MerchantId;
    private Long ownerId;
}
