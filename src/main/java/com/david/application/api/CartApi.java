package com.david.application.api;

import com.david.application.DTO.CartDTO;
import com.david.application.entity.Cart;
import com.david.application.entity.Item;
import com.david.application.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("cart")
@CrossOrigin
public class CartApi {

    @Autowired
    private CartService cartService;

    @GetMapping("/{uuid}")
    public Cart get(@PathVariable String uuid){
        return cartService.getOne(uuid);
    }

    @PostMapping("add-item")
    public ResponseEntity<String> addItem(@RequestParam String product,
                                          @RequestParam String cart,
                                          @RequestParam int quantity) {
        return cartService.addItem(cart, product, quantity);
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
    public Cart create(Cart cart) {
        return cartService.createCart(cart);
    }

}