package com.david.application.api;

import com.david.application.entity.Product;
import com.david.application.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("products")
@CrossOrigin
public class ProductApi {

    @Autowired
    private ProductService productService;

    @GetMapping
    public List<Product> listAll() {
        return productService.listAll();
    }

    @GetMapping("/{sku}")
    public Product get(@PathVariable String sku) {
        return productService.getOne(sku);
    }

    @PostMapping
    public void add(@RequestBody Product product) {
        productService.add(product);
    }

    @DeleteMapping("/{sku}")
    public void deleteBySku(@PathVariable String sku) {
        productService.deleteBySku(sku);
    }

    @PutMapping("/{sku}")
    public void modify(@PathVariable String sku,
                       @RequestBody Product product) {
        productService.modify(sku, product);
    }
}