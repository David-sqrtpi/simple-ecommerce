package com.david.application.api;

import com.david.application.entity.Product;
import com.david.application.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("product")
@CrossOrigin
public class ProductApi {

    @Autowired
    private ProductService productService;

    @GetMapping
    public List<Product> listAll() {
        return productService.listAll();
    }

    @GetMapping("/{product}")
    public Product get(@PathVariable String product) {
        return productService.getOne(product);
    }

    @PostMapping
    public void add(@RequestBody Product product) {
        productService.add(product);
    }

    @DeleteMapping("/{product}")
    public void deleteByUuid(@PathVariable String product) {
        productService.deleteById(product);
    }

    @PutMapping("/{product}")
    public void modify(@PathVariable String uuid, @RequestBody Product product) {
        productService.modify(uuid, product);
    }
}