package com.checkout.paymentgateway.dto.requestDto;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class RequestUpdateDto implements Serializable {
    private Long requestId;
    private String description;
    private String product;
}
