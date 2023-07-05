package com.checkout.paymentgateway.dto.shopperDto;


import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class ShopperAccountNewDto implements Serializable {
    private Long shopperId;
    private Long cardNumber;
    private Long accountId;
}
