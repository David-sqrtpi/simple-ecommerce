package com.david.application.api;

import com.david.application.entity.Cart;
import com.david.application.entity.Item;
import com.david.application.entity.Product;
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

    @PostMapping("create")
    public void create(Cart cart) {
        cartService.createCart(cart);
    }

    @GetMapping("get") //TODO If there aren't any cart throw an exception
    public List<Cart> getAll() {
        return cartService.getAll();
    }

    @GetMapping("get/{uuid}")
    public Cart getOne(@PathVariable String uuid){
        return cartService.getOne(uuid);
    }

    @PostMapping("add-item")
    public ResponseEntity<String> addItem(@RequestBody Item item) {
        return cartService.addItem(item);
    }
    
    @PostMapping("checkout/{cartUuid}")
    public String getTotal(@PathVariable String cartUuid){
        return cartService.getTotal(cartUuid);
    }

    public Product delete (Product product) {
        return product;
    }

    public Product modify(Product product) {
        return product;
    }
}
