package com.david.application.api;

import com.david.application.entity.Product;
import com.david.application.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("product")
@CrossOrigin
public class ProductApi {

    @Autowired
    private ProductService productService;

    @GetMapping("get")
    public Collection<Product> listAll() {
        return productService.listAll();
    }

    @PostMapping("add")
    public ResponseEntity<String> add(@RequestBody Product product) {
        return productService.add(product);
    }

    @DeleteMapping("delete/{uuid}")
    public ResponseEntity<String> deleteByUuid(@PathVariable String uuid) {
        return productService.deleteById(uuid);
    }

    @PutMapping("modify/{uuid}")
    public void modify(@PathVariable String uuid, @RequestBody Product product) {
        productService.modify(uuid, product);
    }
}