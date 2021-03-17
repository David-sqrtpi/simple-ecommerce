package com.david.application.api;

import com.david.application.entity.Product;
import com.david.application.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("product")
public class ProductApi {

    @Autowired
    private ProductService productService;

    @GetMapping("list")
    public Iterable<Product> listAll() {

        return productService.listAll();
    }

    public Product add(Product product) {
        return product;
    }

    public Product delete(Product product) {
        return product;
    }

    public Product modify(Product product) {
        return product;
    }
}