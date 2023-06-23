package com.checkout.paymentgateway.dto;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class AcquiringBankNewDto implements Serializable {

    private String name;

}
