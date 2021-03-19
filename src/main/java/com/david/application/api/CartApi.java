package com.david.application.api;

import com.david.application.entity.Cart;
import com.david.application.entity.Product;
import com.david.application.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("cart")
@CrossOrigin
public class CartApi {

    @Autowired
    private CartService cartService;

    @PostMapping("add")
    public String add(Cart cart, String productUuid, int quantity) {

        cartService.addItem(productUuid, quantity);

        return "Product added";
    }

    public Product delete (Product product) {
        return product;
    }

    public Product modify(Product product) {
        return product;
    }
}
