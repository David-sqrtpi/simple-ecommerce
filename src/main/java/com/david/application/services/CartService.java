package com.david.application.services;

import com.david.application.entity.Cart;
import com.david.application.entity.Item;
import com.david.application.entity.Product;
import com.david.application.enums.CartStatus;
import com.david.application.enums.ProductType;
import com.david.application.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collections;
import java.util.List;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ProductService productService;

    @Autowired
    private ItemService itemService;

    public Cart createCart(Cart cart) {
        return cartRepository.save(cart);
    }

    public ResponseEntity<String> addItem(String cartUuid, String productSku, int quantity) {

        Cart cart = cartRepository.getOne(cartUuid);

        cart.addItem(itemService.buidItem(productSku, quantity));

        cartRepository.save(cart);

        return new ResponseEntity<>("Success",
                HttpStatus.OK);
    }

    public void removeItem(String cartUuid, Item item) {
        Cart cart = cartRepository.getOne(cartUuid);
        if(!isCartChecked(cart)){

        }
    }

    public String check(String cartUuid) {
        Cart cart = cartRepository.getOne(cartUuid);
        if(isCartChecked(cart)){
            return "This cart was checked already";
        }
        cart.setCartStatus(CartStatus.COMPLETED);
        cartRepository.save(cart);
        return "Total is: " + cart.getTotal();
    }

    public Cart getOne(String uuid) {
        return cartRepository.findById(uuid).get();
    }

    private boolean exists(String uuid){
        return cartRepository.existsById(uuid);
    }

    private boolean isCartChecked(Cart cart){
        return cart.getCartStatus().equals(CartStatus.COMPLETED);
    }

}
