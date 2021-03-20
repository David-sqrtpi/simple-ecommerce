package com.david.application.api;

import com.david.application.entity.Cart;
import com.david.application.entity.Product;
import com.david.application.services.CartService;
import com.david.application.services.ItemService;
import com.david.application.services.ProductService;
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
    public void create(Cart cart) {
        cartService.createCard(cart);
    }

    @GetMapping("get") //TODO If there aren't any cart throw an exception
    public Collection<Cart> getAll() {
        return cartService.getAll();
    }

    @GetMapping("get/{uuid}")
    public Cart getOne(@PathVariable String uuid){
        return cartService.getOne(uuid);
    }

    @PostMapping("add/{cartUuid}")
    public void addItem(@RequestParam String productUuid, @RequestParam int quantity, @PathVariable String cartUuid) {
        itemService.addItem(cartUuid, productUuid, quantity);
    }
    
    @PostMapping("checkout/{cartUuid}")
    public String getTotal(@PathVariable String cartUuid){
        return cartService.getTotal(cartService.getOne(cartUuid));
    }

    public Product delete (Product product) {
        return product;
    }

    public Product modify(Product product) {
        return product;
    }
}
