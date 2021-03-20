package com.david.application.api;

import com.david.application.entity.Cart;
import com.david.application.entity.Product;
import com.david.application.services.CartService;
import com.david.application.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("cart")
@CrossOrigin
public class CartApi {

    @Autowired
    private CartService cartService;

    @Autowired
    private ItemService itemService;

    @PostMapping("create")
    public String create(Cart cart) {
        cartService.createCard(cart);
        return "Cart created: " + cart.toString();
    }

    @GetMapping("get")
    public Collection<Cart> getAll() {
        return cartService.getAll();
    }

    @GetMapping("get/{uuid}")
    public Cart getOne(@PathVariable String uuid){
        return cartService.getOne(uuid);
    }

    @PostMapping("add/{cartUuid}")
    public void addItem(@RequestParam String productUuid, @RequestParam int quantity, @PathVariable String cartUuid) {
        itemService.addItem(cartService.getOne(cartUuid), productUuid, quantity);
    }

    public Product delete (Product product) {
        return product;
    }

    public Product modify(Product product) {
        return product;
    }
}
