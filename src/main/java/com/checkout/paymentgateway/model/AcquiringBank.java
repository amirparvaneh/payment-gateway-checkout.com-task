package com.checkout.paymentgateway.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@Entity
@Table(name = "acquiring_bank")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AcquiringBank extends BaseEntity{

    private String name;
    private Long bankCode;
    @ManyToOne
    @JoinColumn(name = "payment_gateway_id")
    private PaymentGateway paymentGateway;
    @OneToMany(mappedBy = "AcquiringBank")
    private List<Account> accountList;

}
