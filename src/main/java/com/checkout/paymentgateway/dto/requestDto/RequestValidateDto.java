package com.checkout.paymentgateway.dto.requestDto;


import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class RequestValidateDto implements Serializable {
    private Long cvv;
    private Long cardNumber;
    private Long merchantId;
    private Long shopperId;
}
