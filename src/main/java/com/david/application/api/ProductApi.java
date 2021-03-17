package com.david.application.api;

import com.david.application.entity.Product;
import com.david.application.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("product")
@CrossOrigin
public class ProductApi {

    @Autowired
    private ProductService productService;

    @GetMapping("list-all")
    public Iterable<Product> listAll() {
        return productService.listAll();
    }

    @PostMapping("add")
    public Product add(@RequestBody Product product) {

        if(productService.existsByUuid(product.getUuid())) {
            product.setDescription("It exists");
            return product;
        }

        product.setUuid(UUID.randomUUID().toString()); //Add a random uuid to the product that just created
        return productService.add(product);
    }


    public Product delete(Product product) {
        return product;
    }

    public Product modify(Product product) {
        return product;
    }
}