package com.david.application.services;

import com.david.application.entity.Product;
import com.david.application.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> listAll(){
        return productRepository.findAll();
    }

    public ResponseEntity<String> add(Product product) {
        if(!exists(product.getUuid())) {
            productRepository.save(product);

            return new ResponseEntity<>("Product has been created",
                    HttpStatus.CREATED);
        }
        return new ResponseEntity<>("Product with uuid "+product.getUuid()+" already exists",
                HttpStatus.INTERNAL_SERVER_ERROR);
    }

    public ResponseEntity<String> deleteById(String uuid) {
        if(exists(uuid)) {
            productRepository.deleteById(uuid);

            return new ResponseEntity<>("Product has been eliminated",
                    HttpStatus.OK);
        }
        return new ResponseEntity<>("Product with uuid "+uuid+" does not exists",
                HttpStatus.INTERNAL_SERVER_ERROR);
    }

    public void modify(String uuid, Product product){
        if(exists(uuid)) {
            productRepository.save(product);
        }
    }

    public Product getOne(String uuid) {
        if(exists(uuid)) {
            return productRepository.getOne(uuid);
        }
        return null;
    }

    private boolean exists(String uuid) {
        return productRepository.existsById(uuid);
    }
}
