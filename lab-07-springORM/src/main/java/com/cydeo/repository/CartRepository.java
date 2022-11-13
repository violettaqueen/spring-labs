package com.cydeo.repository;
import com.cydeo.entity.Cart;
import com.cydeo.enums.DiscountType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {
    //Write a derived query to get all cart by specific discount type
    List<Cart>findAllByDiscountDiscountType(DiscountType discountType);
    //Write a JPQL query to get all cart by customer
    
    //Write a derived query to get all cart by customer and cart state
    //Write a derived query to get all cart by customer and cart state and discount is null condition
    //Write a native query to get all cart by customer and cart state and discount is not null condition
}