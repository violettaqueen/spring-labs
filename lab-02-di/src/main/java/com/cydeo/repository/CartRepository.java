package com.cydeo.repository;

import com.cydeo.model.Product;


public interface CartRepository {
    boolean addCartDatabase(Product product, int quantity);
}
