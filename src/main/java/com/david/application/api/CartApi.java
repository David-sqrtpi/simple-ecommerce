package com.david.application.api;

import com.david.application.DTO.CartDTO;
import com.david.application.entity.Cart;
import com.david.application.entity.Item;
import com.david.application.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("cart")
@CrossOrigin
public class CartApi {

    @Autowired
    private CartService cartService;

    @GetMapping
    public List<Cart> findAll() {
        return cartService.findAll();
    }

    @GetMapping("/{cart}")
    public Cart get(@PathVariable String cart){
        return cartService.getOne(cart);
    }

    @PostMapping
    public Cart create() {
        return cartService.createCart(new Cart());
    }

    @PostMapping("/{cart}")
    public void addItem(@RequestParam String product,
                                          @RequestParam int quantity,
                                          @PathVariable String cart) {
        cartService.addItem(cart, product, quantity);
    }

    @PostMapping("/{cart}/checkout")
    public String checkOut(@PathVariable String cart){
        return cartService.check(cart);
    }

    @DeleteMapping("/{cart}")
    public void deleteItem (@RequestParam String product, @PathVariable String cart) {
        cartService.removeItem(cart, product);
    }

}