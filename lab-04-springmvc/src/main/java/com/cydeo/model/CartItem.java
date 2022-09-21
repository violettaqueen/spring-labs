package com.cydeo.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CartItem {
    private Integer quantity;
    private Product product; //DI
}