package com.checkout.paymentgateway.dto.payment;


import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class PaymentDto implements Serializable {
    private Long accountNumber;
    private Long amount;
}
