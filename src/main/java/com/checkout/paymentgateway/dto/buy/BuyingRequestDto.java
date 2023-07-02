package com.checkout.paymentgateway.dto.buy;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class BuyingRequestDto implements Serializable {

    private Long shopperId;
    private Long price;
    private Long cardNumber;
    private Long paymentGateway;
}
