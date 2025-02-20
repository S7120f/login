package com.login.login.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.login.login.service.ProductService;

@Controller
public class ProductController {
    
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public String showProducts(Model model) {
        model.addAttribute("products", productService.getAllProducts());
        return "products";
    }

    @GetMapping("/products/{id}")
    public String showProductDetails(@PathVariable int id, Model model) {
        model.addAttribute("product", productService.getProductById(id));
        return "product-details";
    }

    
    
}
