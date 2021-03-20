package com.david.application.api;

import com.david.application.entity.Cart;
import com.david.application.entity.ItemDetail;
import com.david.application.entity.Product;
import com.david.application.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Iterator;

@RestController
@RequestMapping("cart")
@CrossOrigin
public class CartApi {

    @Autowired
    private CartService cartService;

    @PostMapping("create")
    public String create(Cart cart) {
        cartService.createCard(cart);
        return "Cart created: " + cart.toString();
    }

    @GetMapping("get")
    public Iterator<Cart> getAll() {
        return cartService.getAll();
    }

    @GetMapping("get/{uuid}")
    public Cart getOne(@PathVariable String uuid){
        return cartService.getOne(uuid);
    }

    @PostMapping("add/{cartUuid}")
    public String add(@RequestParam String productUuid, @RequestParam int quantity, @PathVariable String cartUuid) {

        cartService.addItem(cartUuid, productUuid, quantity);

        return "Product added to cart";
    }

    public Product delete (Product product) {
        return product;
    }

    public Product modify(Product product) {
        return product;
    }
}
