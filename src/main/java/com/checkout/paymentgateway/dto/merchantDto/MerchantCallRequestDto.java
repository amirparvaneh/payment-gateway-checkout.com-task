package com.checkout.paymentgateway.dto.merchantDto;


import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@Builder
public class MerchantCallRequestDto implements Serializable {
    private Long price;
    private Long cvv;
    private Long cardNumber;
    private Date expireDate
    private Long
    private Long
}
