package com.checkout.paymentgateway.dto.paymentGatewayDto;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class PaymentRequestDto implements Serializable {
    private Long requestId;
    private Long shopperId;
    private Long merchantId;
    private Long paymentGatewayId;
}
