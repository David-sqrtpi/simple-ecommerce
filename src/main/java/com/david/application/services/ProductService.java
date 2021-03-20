package com.david.application.services;

import com.david.application.entity.Product;
import com.david.application.enums.ProductType;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class ProductService {

    private final List<Product> Initialproducts = Stream.of(
            new Product("name", 123, "description", 123, ProductType.SIMPLE, "product"),
            new Product("Pintura", 100000, "Descripcion de pintura", 123, ProductType.SIMPLE, "pintura"),
            new Product("Cemento", 200000, "Description de cemento", 123, ProductType.DISCOUNT, "cemento")
    ).collect(Collectors.toList());

    private final ArrayList<Product> products = (ArrayList<Product>) Initialproducts;

    public Iterator<Product> listAll(){
        return products.iterator();
    }

    public String add(Product product) {
        if(!existsByUuid(product.getUuid())) {
            products.add(product);
            return "product added " + product.toString();
        }

        return "This product exists, can't add it to the application";
    }

    public String deleteById(String uuid) {

        if(products.removeIf(product -> product.getUuid().equals(uuid))) {
            return "deleted product with uuid " + uuid;
        }

        return "This product doesn't exists, can't delete it of the application";
    }

    public void modify(Product product) { //TODO Make this stuff working

    }

    public Product getByUuid(String uuid) {
        if(existsByUuid(uuid)){
            for(Product product : products) {
                if (product.getUuid().equals(uuid)) {
                    return product;
                }
            }
        }

        return null;
    }

    private boolean existsByUuid(String uuid) {
        return products.stream().anyMatch(product -> product.getUuid().equals(uuid));
    }
}
