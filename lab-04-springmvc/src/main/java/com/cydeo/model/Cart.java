package com.cydeo.model;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class Cart {
   private UUID id;
   private BigDecimal cartTotalAmount;
   private List<CartItem> cartItemList; //cartItem is a dependency injected to Cart
}