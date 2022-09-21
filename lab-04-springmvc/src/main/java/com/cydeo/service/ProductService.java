package com.cydeo.service;

import com.cydeo.model.Product;
import com.cydeo.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> searchProduct(String name);

    void initialiseProductList();
}