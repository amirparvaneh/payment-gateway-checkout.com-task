package com.checkout.paymentgateway.dto;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class UpdatePaymentGatewayDto implements Serializable {
    private String name;
    private Integer merchantCapacity;
    private Integer requestCapacity;
}
