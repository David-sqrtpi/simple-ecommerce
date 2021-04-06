package com.david.application.services;

import com.david.application.entity.Product;
import com.david.application.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> listAll(){
        return productRepository.findAll();
    }

    public void add(Product product) {
        if(!exists(product.getSku())) {
            productRepository.save(product);

            throw new ResponseStatusException(HttpStatus.CREATED,
                    "Product has been created");
        }
        throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
                "Product with sku"+product.getUuid()+" already exists");
    }

    public void deleteById(String product) {
        if(exists(product)) {
            productRepository.deleteBySku(product);

            throw new ResponseStatusException(HttpStatus.OK,
                    "Product has been eliminated");
        }

        throw new ResponseStatusException(HttpStatus.OK,
                "Product with sku "+product+" does not exists");
    }

    public void modify(String uuid, Product product){
        if(exists(uuid)) {
            productRepository.save(product);
        }
    }

    public Product getOne(String product) {
        return productRepository.findBySku(product);
    }

    private boolean exists(String uuid) {
        return productRepository.existsBySku(uuid);
    }
}
