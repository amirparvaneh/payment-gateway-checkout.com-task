package com.checkout.paymentgateway.model;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "card")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Card extends BaseEntity {

    @NotNull(message = "card number should not be empty !")
    @Digits(integer = 4, fraction = 0, message = "the card number should be 4 digits ! ")
    private Long cardNumber;
    private String cvv;
    private Date expireDate;
    @ManyToOne
    @JoinColumn(name = "acquiring_bank_id")
    private AcquiringBank acquiringBank;
    @ManyToOne
    @JoinColumn(name = "shopper_id")
    private Shopper shopper;

}
