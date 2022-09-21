package com.cydeo.service;

import com.cydeo.model.Cart;
import com.cydeo.model.CartItem;
import com.cydeo.model.Cart;
import com.cydeo.model.CartItem;

import java.util.List;
import java.util.UUID;

public interface CartService {
    List<Cart> retrieveCartList();

    List<CartItem> retrieveCartDetail(UUID cartId);

    void initializeCartList();
}