package com.login.login.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.login.login.model.Product;
import com.login.login.repository.ProductRepository;

@Service
public class ProductServiceImp implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImp(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    
    @Override
    public List<Product> getAllProducts() {
        return (List<Product>) productRepository.findAll();
    }


    @Override
    public Product getProductById(int id) {
        Optional<Product> product = productRepository.findById(id);
        return product.orElse(null);
    }

    
    
}
