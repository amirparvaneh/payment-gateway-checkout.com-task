package com.checkout.paymentgateway.dto.bankDto;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class AcquiringBankUpdateDto implements Serializable {
    private Long bankId;
    private String bankName;
    private
}
