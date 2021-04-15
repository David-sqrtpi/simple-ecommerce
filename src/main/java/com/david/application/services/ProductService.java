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

    public Product getOne(String sku) {
        return productRepository.findBySku(sku);
    }

    public void add(Product product) {
        if(!productRepository.existsBySku(product.getSku())) {
            productRepository.save(product);

            throw new ResponseStatusException(HttpStatus.CREATED,
                    "Product has been created");
        }
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                "Product with sku "+product.getSku()+" already exists");
    }

    public void deleteBySku(String sku) {
        if(productRepository.existsBySku(sku)) {
            productRepository.deleteBySku(sku);

            throw new ResponseStatusException(HttpStatus.OK,
                    "Product has been eliminated");
        }

        throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                "Product with sku "+sku+" does not exists");
    }

    public void modify(String sku, Product product){
        if(productRepository.existsBySku(sku)) {

            Product newProduct = productRepository.getOneBySku(sku);
            newProduct.setPrice(product.getPrice());
            newProduct.setName(product.getName());
            productRepository.save(newProduct);
            
            throw new ResponseStatusException(HttpStatus.OK,
                    "Product has been modified");
        }

        throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                "Product with sku "+sku+" does not exists");
    }
}
//TODO think about final field UUID (if it's neccesary or not)