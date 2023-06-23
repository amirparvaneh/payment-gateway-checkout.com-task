package com.checkout.paymentgateway.dto;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;


@Data
@Builder
public class MerchantNewDto implements Serializable {

    private String name;
    private Long paymentGatewayId;
}
