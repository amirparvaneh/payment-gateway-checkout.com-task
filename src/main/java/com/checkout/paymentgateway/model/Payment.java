package com.checkout.paymentgateway.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "payment")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment extends BaseEntity{
    private Long transactionId;
    private Long paymentGatewayId;
    private Date createdDate;
    private PaymentStatus  paymentStatus;
}
