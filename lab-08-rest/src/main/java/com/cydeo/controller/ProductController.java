package com.cydeo.controller;

import com.cydeo.dto.ProductDTO;
import com.cydeo.dto.ProductRequest;
import com.cydeo.dto.ResponseWrapper;
import com.cydeo.entity.Category;
import com.cydeo.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<ResponseWrapper> getProductList() {
        List<ProductDTO> productDTOList = productService.getProductList();
        return ResponseEntity.ok(new ResponseWrapper("Products are successfully retrieved", productDTOList, HttpStatus.OK));
    }

    @GetMapping("/top3")
    public ResponseEntity<ResponseWrapper> getTop3ProductList() {
        List<ProductDTO> productDTOList = productService.getTop3ProductList();
        return ResponseEntity.ok(new ResponseWrapper("Products are successfully retrieved", productDTOList, HttpStatus.OK));
    }

    @GetMapping("/{name}")
    public ResponseEntity<ResponseWrapper> getProductListByName(@PathVariable("name") String name) {
        ProductDTO product = productService.getProductByName(name);
        return ResponseEntity.ok(new ResponseWrapper("Product is successfully retrieved", product, HttpStatus.OK));
    }

    @PostMapping
    public ResponseEntity<ResponseWrapper> createProduct(@RequestBody ProductDTO productDTO) {
        productService.save(productDTO);
        return ResponseEntity.ok(new ResponseWrapper("Product is successfully created", productDTO, HttpStatus.OK));
    }

    @PutMapping
    public ResponseEntity<ResponseWrapper> updateProduct(@RequestBody ProductDTO productDTO) {
        productService.update(productDTO);
        return ResponseEntity.ok(new ResponseWrapper("Product is successfully retrieved", productDTO, HttpStatus.OK));
    }

    @GetMapping("/price/{price}/quantity/{quantity}")
    public ResponseEntity<ResponseWrapper> getProductListByPriceAndQuantity(@PathVariable("price") BigDecimal price,
                                                                            @PathVariable("quantity") Integer quantity) {

        List<ProductDTO> productDTOList = productService.getProductListByPriceAndQuantity(price, quantity);
        return ResponseEntity.ok(new ResponseWrapper("Products are successfully retrieved", productDTOList, HttpStatus.OK));

    }

    @GetMapping("/price/{price}")
    public ResponseEntity<ResponseWrapper> getProductListByPrice(@PathVariable("price") BigDecimal price) {

        Integer productDTOList = productService.getProductListByPrice(price);
        return ResponseEntity.ok(new ResponseWrapper("Products are successfully retrieved", productDTOList, HttpStatus.OK));

    }


    @GetMapping("/category/{id}")
    public ResponseEntity<ResponseWrapper> getProductListByCategory(@PathVariable("id") Long id) {

        List<ProductDTO> productDTOList = productService.getProductListByCategory(id);
        return ResponseEntity.ok(new ResponseWrapper("Products are successfully retrieved", productDTOList, HttpStatus.OK));
    }

    @PostMapping("/categoryandprice")
    public ResponseEntity<ResponseWrapper> getProductListByCategoryAndPrice(@RequestBody ProductRequest productRequest) {

        List<ProductDTO> productDTOList = productService.getProductListByCategoryListAndPrice(productRequest.getCategoryList(), productRequest.getPrice());
        return ResponseEntity.ok(new ResponseWrapper("Product list is successfully retrieved", productDTOList, HttpStatus.OK));
    }
}