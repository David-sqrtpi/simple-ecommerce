package com.david.application.services;

import com.david.application.entity.Product;
import com.david.application.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Iterable<Product> listAll(){
        return productRepository.findAll();
    }

    public void add(Product product) {
        productRepository.save(product);
    }

    public boolean existsByUuid(String uuid) {
        return productRepository.existsByUuid(uuid);
    }

    public void deleteById(String uuid) {
        productRepository.deleteById(uuid);
    }

    public void modify(Product product) {
        productRepository.save(product);
    }

    public Product getByUuid(String uuid) {
        return productRepository.getOne(uuid);
    }
}
