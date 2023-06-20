package com.checkout.paymentgateway.model;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "acquiring-bank")
@NoArgsConstructor
@AllArgsConstructor
public class AcquiringBank extends BaseEntity{
    private String name;
    private String bankCode;
    private Long paymentGateway;
    @OneToMany()
    private Long cardId;
}
