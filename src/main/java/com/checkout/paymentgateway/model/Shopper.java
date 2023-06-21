package com.checkout.paymentgateway.model;


import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@Table(name = "shooper")
@NoArgsConstructor
@AllArgsConstructor
public class Shopper extends BaseEntity{

    private String name;
    @OneToMany(mappedBy = "shopper")
    private List<Card> card;
}
