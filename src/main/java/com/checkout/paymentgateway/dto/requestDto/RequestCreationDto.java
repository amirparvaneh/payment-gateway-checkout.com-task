package com.checkout.paymentgateway.dto.requestDto;


import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@Builder
public class RequestCreationDto implements Serializable {
    private Date createdOn;
    private Long amount;
    private String description;
    private Long shopperId;
    private Long merchantId;
    private Long paymentGatewayId;
}
