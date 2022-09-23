package com.cydeo.controller;

import com.cydeo.service.ProductService;
import com.cydeo.service.impl.ProductServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProductController {
    @RequestMapping("/search-product/{name}")
    public String searchProduct(@PathVariable String name, Model model){

        model.addAttribute("product", ProductServiceImpl.PRODUCT_LIST);

        return "product/product-list";
    }
}
