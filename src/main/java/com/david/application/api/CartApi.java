package com.david.application.api;

import com.david.application.DTO.CartDTO;
import com.david.application.entity.Cart;
import com.david.application.entity.Item;
import com.david.application.entity.Product;
import com.david.application.services.CartService;
import com.david.application.util.CartConstructor;
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

    @Autowired
    CartConstructor cartConstructor;

    @GetMapping("get/{uuid}")
    public CartDTO getOne(@PathVariable String uuid){
        return cartConstructor.construct(uuid);
    }

    @PostMapping("add-item/{cartUuid}")
    public ResponseEntity<String> addItem(@RequestBody Item item, @PathVariable String cartUuid) {
        return cartService.addItem(cartUuid, item);
    }

    @DeleteMapping("delete-item/{cartUuid}")
    public void deleteItem (@RequestBody Item item, @PathVariable String cartUuid) {
        cartService.removeItem(cartUuid, item);
    }

    @PostMapping("checkout/{cartUuid}")
    public String getTotal(@PathVariable String cartUuid){
        return cartService.check(cartUuid);
    }

    @PostMapping("create")
    public void create(Cart cart) {
        cartService.createCart(cart);
    }

}