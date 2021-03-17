package com.david.application.api;

import com.david.application.entity.Product;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("cart")
public class CartApi {

    public Product add(Product product) {
        return product;
    }

    public Product delete (Product product) {
        return product;
    }

    public Product modify(Product product) {
        return product;
    }
}
