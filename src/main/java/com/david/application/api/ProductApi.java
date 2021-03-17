package com.david.application.api;

import com.david.application.entity.Product;
import com.david.application.services.ProductService;
import com.david.application.services.UuidGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("product")
@CrossOrigin
public class ProductApi {

    @Autowired
    private ProductService productService;

    @Autowired
    UuidGenerator uuidGenerator;

    @GetMapping("list-all")
    public Iterable<Product> listAll() {
        return productService.listAll();
    }

    @PostMapping("add")
    public Product add(@RequestBody Product product) {

        if(findByUuid(product.getUuid())) {
            return null;
        }

        product.setUuid(uuidGenerator.generateUuid());

        return productService.add(product);
    }

    @DeleteMapping("delete-by-id")
    public String deleteByUuid(String uuid) {
        productService.deleteById(uuid);
        return "deleted product with uuid " + uuid;
    }

    @PutMapping("modify-by-id")
    public Product modify(Product product) {
        productService.modify(product);
        return product;
    }

    private boolean findByUuid(String uuid) {
        return productService.existsByUuid(uuid);
    }
}