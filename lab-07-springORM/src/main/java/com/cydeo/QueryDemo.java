package com.cydeo;

import com.cydeo.repository.CartItemRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class QueryDemo implements CommandLineRunner {

    private final CartItemRepository cartItemRepository;

    public QueryDemo(CartItemRepository cartItemRepository) {
        this.cartItemRepository = cartItemRepository;
    }

    @Override
    public void run(String... args) throws Exception {


        System.out.println();
    }
}
