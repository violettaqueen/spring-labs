package com.cydeo.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Component

public class Cart {
   private UUID id;
   private BigDecimal cartTotalAmount;
   private List<CartItem> cartItemList; //cartItem is a dependency injected to Cart
}