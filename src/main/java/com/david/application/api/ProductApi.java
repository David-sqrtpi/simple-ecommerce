package com.david.application.api;

import com.david.application.entity.Product;
import com.david.application.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
        return productService.add(product);
    }


    public Product delete(Product product) {
        return product;
    }

    public Product modify(Product product) {
        return product;
    }
}