package com.david.application.services;

import com.david.application.entity.Cart;
import com.david.application.entity.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;

@Service
public class CartService {

    @Autowired
    ProductService productService;

    private final HashMap<String, Cart> carts = new HashMap<>();

    public void createCard(Cart cart) {
        carts.put(cart.getUuid(), cart);
    }

    public Collection<Cart> getAll() {
        return carts.values();
    }

    public String check(String uuid) {
        return "Total is: ";
    }

    public Cart getOne(String uuid) {
        return carts.get(uuid);
    }
}
