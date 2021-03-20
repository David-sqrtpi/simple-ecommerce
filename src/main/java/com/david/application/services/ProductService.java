package com.david.application.services;

import com.david.application.entity.Product;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;

@Service
public class ProductService {

    private final HashMap<String, Product> products = new HashMap<>();

    public Collection<Product> listAll(){
        return products.values();
    }

    public void add(Product product) {
        products.put(product.getUuid(), product);
    }

    public void deleteById(String uuid) {
        products.remove(uuid);
    }

    public void modify(Product product) { //TODO Make this stuff working
        products.replace(product.getUuid(), product);
    }

    public Product getOne(String uuid) {
        return products.get(uuid);
    }
}
