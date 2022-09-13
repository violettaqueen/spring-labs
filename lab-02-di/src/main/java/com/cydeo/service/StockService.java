package com.cydeo.service;

import com.cydeo.model.Product;

public interface StockService {
    boolean checkStockIsAvailable(Product product, int quantity);
}
