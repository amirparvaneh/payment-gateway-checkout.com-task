package com.checkout.paymentgateway.dto.shopperDto;


import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class ShopperUpdateDto implements Serializable {
    private Long shopperId;
    private String name;
}
