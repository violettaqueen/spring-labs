package com.cydeo.model;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Map;

@Getter
@Setter
public class Cart {
    private Product product;
    private Map<Product, Integer> productMap;
    private BigDecimal cartTotalAmount;

}
