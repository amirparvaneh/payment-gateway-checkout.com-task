package com.checkout.paymentgateway.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "merchant")
@NoArgsConstructor
@AllArgsConstructor
public class Merchant extends BaseEntity{
}
