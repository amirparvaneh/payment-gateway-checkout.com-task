package com.checkout.paymentgateway.dto;


import com.checkout.paymentgateway.model.Request;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class PaymentRequestDto implements Serializable {
    private Request request;
}
