package com.david.application.services;

import com.david.application.entity.Product;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;

@Service
public class ProductService {

    private final HashMap<String, Product> products = new HashMap<>();

    public Collection<Product> listAll(){
        return products.values();
    }

    public ResponseEntity<String> add(Product product) {
        if(!exists(product.getUuid())) {
            products.put(product.getUuid(), product);
            return new ResponseEntity<>("Product has been created",
                    HttpStatus.CREATED);
        }
        return new ResponseEntity<>("Product with uuid "+product.getUuid()+" already exists",
                HttpStatus.INTERNAL_SERVER_ERROR);
    }

    public ResponseEntity<String> deleteById(String uuid) {
        if(exists(uuid)) {
            products.remove(uuid);
            return new ResponseEntity<>("Product has been eliminated",
                    HttpStatus.OK);
        }
        return new ResponseEntity<>("Product with uuid "+uuid+" does not exists",
                HttpStatus.INTERNAL_SERVER_ERROR);
    }

    public void modify(String uuid, Product product){
        if(exists(uuid)) {
            products.replace(uuid, product);
        }
    }

    public Product getOne(String uuid) {
        if(exists(uuid)) {
            return products.get(uuid);
        }
        return null;
    }

    private boolean exists(String uuid) {
        return products.containsKey(uuid);
    }
}
