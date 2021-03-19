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

    @Autowired
    UuidGenerator uuidGenerator;

    @GetMapping("list-all")
    public Iterable<Product> listAll() {
        return productService.listAll();
    }

    @PostMapping("add")
    public String add(@RequestBody Product product) {

        if(ExistsByUuid(product.getUuid())) {
            return "This product exists, can't add it to the application";
        }

        productService.add(product);

        return "Product added with uuid " +
                product.getUuid() +
                " and sku " +
                product.getSku();
    }

    @DeleteMapping("delete-by-id/{uuid}")
    public String deleteByUuid(@PathVariable String uuid) {

        if(ExistsByUuid(uuid)) {
            return "This product doesn't exists, can't delete it of the application";
        }
        productService.deleteById(uuid);
        return "deleted product with uuid " + uuid;
    }

    @PutMapping("modify-by-id/{uuid}")
    public String modify(@PathVariable String uuid, @RequestBody Product product) {

        if(!ExistsByUuid(uuid)) {
            return "This product doesn't exists, can't modify in application";
        }

        productService.modify(product);

        return "Product with uuid " +
                uuid +
                " has been modified";
    }

    private boolean ExistsByUuid(String uuid) {
        return productService.existsByUuid(uuid);
    }
}