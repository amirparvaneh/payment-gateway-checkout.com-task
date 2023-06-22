package com.checkout.paymentgateway.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Entity
@Table(name = "acquiring_bank")
@NoArgsConstructor
@AllArgsConstructor
public class AcquiringBank extends BaseEntity{

    private String name;
    private String bankCode;
    @ManyToOne
    @JoinColumn(name = "payment_gateway_id")
    private PaymentGateway paymentGateway;

}
