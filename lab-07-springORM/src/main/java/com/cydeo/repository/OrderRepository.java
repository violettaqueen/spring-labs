package com.cydeo.repository;

import com.cydeo.entity.Order;
import com.cydeo.enums.PaymentMethod;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;


@Repository
public interface OrderRepository extends JpaRepository<Order,Long > {

    //Write a derived query to get top 5 orders by order by total price desc
    List<Order>findTop5ByOrderByTotalPriceDesc();

    //Write a derived query to get all orders by customer email
    List<Order> findAllByCustomerEmail(String email);

    //Write a derived query to get all orders by specific payment method
    List<Order> findAllByPayment_PaymentMethod(PaymentMethod paymentMethod);


    //Write a derived query to check is there any orders by customer email
    boolean existsByCustomerEmail(String email);

    //Write a native query to get all orders by specific product name
    @Query(value = "select * from orderc o join cart c on cart_id = c.id" +
            "join cart_item ci on ci.cart_id = c.id" +
            "join product p on ci.product_id = p.id where p.name =?1  ", nativeQuery = true)
     List<Order> retrieveAllOrdersByProductName(String name);


    //Write a native query to get all orders by specific categoryId
    @Query(value = "select * from orderc o join cart c on cart_id = c.id" +
            "join cart_item ci on ci.cart_id = c.id" +
            "join product p on ci.product_id = p.id" +
            "join category ca on ca.id = p.c_id where ca.id = ?1", nativeQuery = true)
    List<Order> retrieveAllOrdersByCategoryId(Long id);


    //Write a JPQL query to get all orders by totalPrice and paidPrice are equals
    @Query("select o from Order o where o.totalPrice = o.paidPrice")
    List<Order> findAllByTotalPriceAndPaidPriceEquals();


    //Write a derived query to get all orders by totalPrice and paidPrice are not equals and discount is not null
    @Query("select o from Order o where o.paidPrice <> o.totalPrice and o.cart.discount is not null")
    List<Order> findAllByTotalPriceAndPaidPriceNotEqualsAndDiscountIdIsNotNull();



}