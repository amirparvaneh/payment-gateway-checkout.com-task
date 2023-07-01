package com.checkout.paymentgateway.dto.buy;


import com.checkout.paymentgateway.model.PaymentStatus;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.sql.Time;
import java.util.Date;

@Data
@Builder
public class BuyingResponseDto implements Serializable {

    private Date endDate;
    private Time endTime;
    private PaymentStatus paymentStatus;

}
