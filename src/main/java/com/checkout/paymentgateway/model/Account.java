package com.checkout.paymentgateway.model;


import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Entity
@Table(name = "account")
@AllArgsConstructor
@Data
@Builder
public class Account extends BaseEntity {
    @NotNull
    private Long accountNumber;
    private Long balance;
    private Long MerchantId;
    private Long ownerId;
    @ManyToOne
    @JoinColumn(name = "acquiring_bank_id")
    private AcquiringBank acquiringBank;
}
