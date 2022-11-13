package com.cydeo.repository;


import com.cydeo.entity.Cart;
import com.cydeo.enums.CartState;
import com.cydeo.enums.DiscountType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartItemRepository extends JpaRepository<CartItemRepository, Long> {

    //Write a derived query to get count cart items
    Integer countAllBy(List<CartItemRepository> cartItemList);
    //Write a derived query to get cart items for specific cart state
    List<CartItemRepository> findByCartCartState(CartState cart_cartState);
    //Write a native query to get cart items for specific cart state and product name
    @Query(value = "select * from cart_item ci join cart c on c.id = ci.cart_id" +
            "join product p on p.id = ci.product_id" +
            "where c.cart_state = ?1 and p.name = ?2", nativeQuery = true)
    List<CartItemRepository> retrieveAllByCartStateProductName(CartState cartState, String productName);
    //Write a native query to get cart items for specific cart state and without discount
    @Query(value = "select * from cart_item ci join cart on c.id = ci.cart_id"+
            "join discount d on d.id = c.discount_id" +
            "where c.cart_state = ?1 and c.discount_id = 0", nativeQuery = true)
    List<CartItemRepository> retrieveAllByCartStateNoDiscount(CartState cartState);
    //Write a native query to get cart items for specific cart state and with specific Discount type
    @Query(value = "select * from cart_item ci" +
            "join cart c on c.id = ci.cart_id" +
            "join discount d on d.id = c.discount_id"+
            "where c.cart_state = ?1 and d.discount_type", nativeQuery = true)
   List<CartItemRepository> retrieveAllWithCartStateAndDiscountType(CartState cartState, DiscountType discountType);


}