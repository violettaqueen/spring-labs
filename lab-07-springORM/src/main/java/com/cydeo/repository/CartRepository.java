package com.cydeo.repository;
import com.cydeo.entity.Cart;
import com.cydeo.entity.Customer;
import com.cydeo.enums.CartState;
import com.cydeo.enums.DiscountType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {
    //Write a derived query to get all cart by specific discount type
    List<Cart>findAllByDiscountDiscountType(DiscountType discountType);

    //Write a JPQL query to get all cart by customer
    @Query("select c from Cart c where c.customer.id = ?1")
    List<Cart> readAllByCustomer(Customer customer);

    //Write a derived query to get all cart by customer and cart state
     List<Cart> findByCustomerIdAndCartState(Long id, CartState cartState);


     //Write a derived query to get all cart by customer and cart state and discount is null condition
    List<Cart> findAllByCustomerIdAndCartStateAndDiscountIsNull(Long id, CartState cartState);

    //Write a native query to get all cart by customer and cart state and discount is not null condition
    @Query(value = "select * from cart c join customer cu on cu.id = customer_id where c.cartState = ?1" +
            "and cu.id = ?2 and discunt.id <> null", nativeQuery = true)
    List<Cart> findAllByCustomerIdAndCartStateAndDiscountIsNotNull(String cartState, Long id);
}