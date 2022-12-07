package com.cydeo.service.impl;

import com.cydeo.dto.ProductDTO;
import com.cydeo.dto.ProductRequest;
import com.cydeo.entity.Category;
import com.cydeo.entity.Product;
import com.cydeo.mapper.MapperUtil;
import com.cydeo.repository.ProductRepository;
import com.cydeo.service.ProductService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    private final MapperUtil mapperUtil;
    private final ProductRepository productRepository;

    public ProductServiceImpl(MapperUtil mapperUtil, ProductRepository productRepository) {
        this.mapperUtil = mapperUtil;
        this.productRepository = productRepository;
    }

    @Override
    public ProductDTO save(ProductDTO productDTO) {
        Product productToSave = mapperUtil.convert(productDTO, new Product());
        productRepository.save(productToSave);
        return productDTO;
    }

    @Override
    public ProductDTO update(ProductDTO productDTO) {
        Product productToUpdate = mapperUtil.convert(productDTO, new Product());
        productRepository.save(productToUpdate);
        return productDTO;
    }

    @Override
    public List<ProductDTO> getProductList() {
        List<Product> productList = productRepository.findAll();
        return productList.stream()
                .map(product -> mapperUtil.convert(product, new ProductDTO()))
                .collect(Collectors.toList());
    }

    @Override
    public List<ProductDTO> getTop3ProductList() {
        List<Product> productList = productRepository.findTop3ByOrderByPriceDesc();
        return productList.stream()
                .map(product -> mapperUtil.convert(product, new ProductDTO()))
                .collect(Collectors.toList());
    }

    @Override
    public ProductDTO getProductByName(String name) {
        Product productToFind = productRepository.findFirstByName(name);
        return mapperUtil.convert(productToFind, new ProductDTO());
    }

    @Override
    public List<ProductDTO> getProductListByCategory(Long categoryId) {
        List<Product> productList = productRepository.retrieveProductListByCategory(categoryId);

        return productList.stream()
                .map(product -> mapperUtil.convert(product, new ProductDTO()))
                .collect(Collectors.toList());
    }

    @Override
    public Integer getProductListByPrice(BigDecimal price) {
        return productRepository.countProductByPriceGreaterThan(price);
    }

    @Override
    public List<ProductDTO> getProductListByPriceAndQuantity(BigDecimal price, Integer quantity) {
        List<Product> productList = productRepository.getAllByPriceAndQuantity(price, quantity);

        return productList.stream()
                .map(product -> mapperUtil.convert(product, new ProductDTO()))
                .collect(Collectors.toList());
    }

    @Override
    public List<ProductDTO> getProductListByCategoryListAndPrice(ProductRequest productRequest) {
        List<Product> productList = productRepository.retrieveProductListByCategory(productRequest.getCategoryList(), productRequest.getPrice());
        return productList.stream()
                .map(product -> mapperUtil.convert(product, new ProductDTO()))
                .collect(Collectors.toList());


    }
}
