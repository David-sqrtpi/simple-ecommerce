package com.david.application.services;

import com.david.application.entity.Cart;
import com.david.application.entity.Item;
import com.david.application.enums.CartStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;

@Service
public class CartService {

    private final HashMap<String, Cart> carts = new HashMap<>();

    public void createCard(Cart cart) {
        carts.put(cart.getUuid(), cart);
    }

    public Collection<Cart> getAll() {
        return carts.values();
    }

    public void addItem(){

    }

    public String getTotal(Cart cart) {
        cart.setCartStatus(CartStatus.COMPLETED);
        return "Total is: " + cart.getTotal();
    }

    public Cart getOne(String uuid) {
        return carts.get(uuid);
    }
}
