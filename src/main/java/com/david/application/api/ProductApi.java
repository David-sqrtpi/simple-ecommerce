package com.david.application.api;

import com.david.application.entity.Product;
import com.david.application.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public void add(@RequestBody Product product) {
        productService.add(product);
    }

    @DeleteMapping("delete/{uuid}")
    public void deleteByUuid(@PathVariable String uuid) {
        productService.deleteById(uuid);
    }

    @PutMapping("modify/{uuid}") //TODO Make this stuff working
    public void modify(@PathVariable String uuid, @RequestBody Product product) {
        productService.modify(product);
    }
}