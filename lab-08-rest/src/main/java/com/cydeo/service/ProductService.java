package com.cydeo.service;

import com.cydeo.dto.ProductDTO;
import com.cydeo.dto.ProductRequest;
import com.cydeo.entity.Category;

import java.math.BigDecimal;
import java.util.List;

public interface ProductService {

    ProductDTO save(ProductDTO productDTO);
    ProductDTO update(ProductDTO productDTO);
    List<ProductDTO> getProductList();
    List<ProductDTO> getTop3ProductList();
    ProductDTO getProductByName(String name);
    List<ProductDTO> getProductListByCategory(Long id);
    Integer getProductListByPrice(BigDecimal price);
    List<ProductDTO> getProductListByPriceAndQuantity(BigDecimal price, Integer quantity);
    List<ProductDTO> getProductListByCategoryListAndPrice(List<Long> categoryList, BigDecimal price);



}
