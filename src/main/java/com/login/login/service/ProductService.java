package com.login.login.service;

import java.util.List;

import com.login.login.model.Product;

public interface ProductService {
    List<Product> getAllProducts();
    Product getProductById(int id);
}
