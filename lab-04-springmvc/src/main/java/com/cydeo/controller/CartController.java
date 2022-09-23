package com.cydeo.controller;

import com.cydeo.service.CartService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.UUID;

@Controller
public class CartController {

    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @RequestMapping("/cart-list")
    public String cartList(Model model){
        model.addAttribute("cartList",cartService.retrieveCartList());

        return "cart/cart-list.html";
    }
    @RequestMapping("/cart-list/{cartId}")
    public String retrieveListOfCartItems(@PathVariable UUID cartId, Model model){

        model.addAttribute("cartItemList", cartService.retrieveCartDetail(cartId));

        return "cart/cart-detail.html";
    }

}
