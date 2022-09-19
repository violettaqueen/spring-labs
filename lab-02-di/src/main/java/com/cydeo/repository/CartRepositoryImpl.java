package com.cydeo.repository;


import com.cydeo.model.Cart;
import com.cydeo.model.Product;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;
@Getter
@Setter
@Component
public class CartRepositoryImpl implements CartRepository {

    public boolean addCartDatabase(Product product, int quantity) {
        System.out.println(product.getName() + " is added to database");
        return true;
    }
}
