package com.david.application.api;

import com.david.application.DTO.CartDTO;
import com.david.application.DTOConverter.CartConverter;
import com.david.application.entity.Cart;
import com.david.application.entity.Item;
import com.david.application.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("carts")
@CrossOrigin
public class CartApi {

    @Autowired
    private CartService cartService;

    @Autowired
    private CartConverter cartConverter;

    @GetMapping
    public List<CartDTO> findAll() {
        return cartConverter.fromEntity(cartService.findAll());
    }

    @GetMapping("/{cart}")
    public CartDTO getOne(@PathVariable String cart){
        return cartConverter.fromEntity(cartService.getOne(cart));
    }

    @PostMapping
    public CartDTO create() {
        return cartConverter.fromEntity(cartService.createCart());
    }

    @PostMapping("/{cart}")
    public void addItem(@PathVariable String cart,
                        @RequestParam String productSku,
                        @RequestParam int productQuantity) {
        cartService.addItem(cart, productSku, productQuantity);
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