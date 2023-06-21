package com.checkout.paymentgateway.dto;

import com.checkout.paymentgateway.model.PaymentStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
public class PaymentResponseDto implements Serializable {

    private PaymentStatus paymentStatus;
}
