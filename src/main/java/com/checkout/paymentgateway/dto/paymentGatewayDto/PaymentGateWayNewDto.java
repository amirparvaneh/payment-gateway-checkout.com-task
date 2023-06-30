package com.checkout.paymentgateway.dto.paymentGatewayDto;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;


@Data
@Builder
public class PaymentGateWayNewDto implements Serializable {

    private String name;
    private Integer merchantCapacity;
    private Integer requestCapacity;

}
