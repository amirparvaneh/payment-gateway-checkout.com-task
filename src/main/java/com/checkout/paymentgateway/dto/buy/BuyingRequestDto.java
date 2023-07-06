package com.checkout.paymentgateway.dto.buy;

import com.checkout.paymentgateway.model.Card;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class BuyingRequestDto implements Serializable {
    private Long shopperId;
    private Long price;
    private Long paymentGateway;
    private Card card;
    private Long merchantId;
    private String product;
    private String description;
}
