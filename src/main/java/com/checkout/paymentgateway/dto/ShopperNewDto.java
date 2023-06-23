package com.checkout.paymentgateway.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class ShopperNewDto implements Serializable {

    private String bankName;
    @NotNull(message = "card number mandatory")
    private Long cardNumber;
}
