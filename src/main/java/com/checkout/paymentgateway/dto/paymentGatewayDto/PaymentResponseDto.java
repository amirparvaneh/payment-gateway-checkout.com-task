package com.checkout.paymentgateway.dto.paymentGatewayDto;

import com.checkout.paymentgateway.model.PaymentStatus;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class PaymentResponseDto implements Serializable {
    private PaymentStatus paymentStatus;
    private Long price;
    private String product;
    private String description;
}
