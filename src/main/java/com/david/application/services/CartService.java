package com.david.application.services;

import com.david.application.entity.Cart;
import com.david.application.enums.CartStatus;
import com.david.application.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    public void createCart(Cart cart) {
        cartRepository.save(cart);
    }

    public List<Cart> getAll() {
        return cartRepository.findAll();
    }

    public void addItem(){

    }

    public String getTotal(Cart cart) {
        cart.setCartStatus(CartStatus.COMPLETED);
        return "Total is: " + cart.getTotal();
    }

    public Cart getOne(String uuid) {
        return cartRepository.findById(uuid).get();
    }
}
