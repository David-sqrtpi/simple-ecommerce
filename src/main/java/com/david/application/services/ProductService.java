package com.david.application.services;

import com.david.application.entity.Product;
import com.david.application.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Iterable<Product> listAll(){
        return productRepository.findAll();
    }
}
