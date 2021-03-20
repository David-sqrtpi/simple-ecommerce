package com.david.application.api;

import com.david.application.entity.Product;
import com.david.application.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Iterator;

@RestController
@RequestMapping("product")
@CrossOrigin
public class ProductApi {

    @Autowired
    private ProductService productService;


    @GetMapping("get")
    public Iterator<Product> listAll() {
        return productService.listAll();
    }

    @PostMapping("add")
    public String add(@RequestBody Product product) {
        return productService.add(product);
    }

    @DeleteMapping("delete/{uuid}")
    public String deleteByUuid(@PathVariable String uuid) {
        return productService.deleteById(uuid);
    }

    @PutMapping("modify/{uuid}") //TODO Make this stuff working
    public String modify(@PathVariable String uuid, @RequestBody Product product) {
        return "Product with uuid " +
                uuid +
                " has been modified";
    }
}