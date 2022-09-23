package com.cydeo.service.impl;

import com.cydeo.model.Product;
import com.cydeo.service.ProductService;
import com.cydeo.model.Product;
import com.cydeo.service.ProductService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {
    public static List<Product> PRODUCT_LIST = new ArrayList<>();
    Product product;

    public ProductServiceImpl(Product product) {
        this.product = product;
    }

    @Override
    public List<Product> searchProduct(String name) {
        // todo implement search structure using string startsWith function
        return PRODUCT_LIST.stream()
                .filter(product -> product.getName().startsWith(name))
                .collect(Collectors.toList());

    }

    @Override
    public void initialiseProductList() {             //creating product object
        Product product1 = new Product();
        product1.setId(UUID.randomUUID());
        product1.setName("milk");
        product1.setPrice(new BigDecimal(7));
        product1.setRemainingQuantity(24);
        product1.setQuantity(24);
        PRODUCT_LIST.add(product1);                 //adding product in the list


        Product product2 = new Product();
        product2.setId(UUID.randomUUID());
        product2.setName("milkshake");
        product2.setPrice(new BigDecimal(22));
        product2.setRemainingQuantity(24);
        product2.setQuantity(24);
        PRODUCT_LIST.add(product2);

        Product product3 = new Product();
        product3.setId(UUID.randomUUID());
        product3.setName("xbox");
        product3.setPrice(new BigDecimal(4500));
        product3.setRemainingQuantity(24);
        product3.setQuantity(24);
        PRODUCT_LIST.add(product3);

        Product product4 = new Product();
        product4.setId(UUID.randomUUID());
        product4.setName("xboxs");
        product4.setPrice(new BigDecimal(4500));
        product4.setRemainingQuantity(24);
        product4.setQuantity(24);
        PRODUCT_LIST.add(product4);

    }
}