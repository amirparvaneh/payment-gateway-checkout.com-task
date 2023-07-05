package com.checkout.paymentgateway.dto.merchantDto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MerchantAccountNewDto {
    private Long merchantId;
    private Long bankId;
}
