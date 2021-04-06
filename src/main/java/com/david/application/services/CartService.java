package com.david.application.services;

import com.david.application.entity.Cart;
import com.david.application.enums.CartStatus;
import com.david.application.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ItemService itemService;

    public List<Cart> findAll() {
        return cartRepository.findAll();
    }

    public Cart createCart(Cart cart) {
        return cartRepository.save(cart);
    }

    public void addItem(String cartUuid, String product, int quantity) {

        if (!cartRepository.existsById(cartUuid)){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        Cart cart = cartRepository.findById(cartUuid).get();

        System.out.println(hasProduct(cart, product));

        cart.addItem(itemService.buidItem(product, quantity));

        cartRepository.save(cart);

        throw new ResponseStatusException(HttpStatus.CREATED, "Item has been added");
    }

    public void removeItem(String cartUuid, String product) {
        Cart cart = cartRepository.getOne(cartUuid);
        if(!isCartChecked(cart)){
            System.out.println("do some stuff");
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

    private boolean hasProduct(Cart cart, String product) {

        if (cart.getItems().stream().anyMatch(item -> item.getProduct().getSku().equals(product))){
            return true; //exists
        }
        return false; //it is new
    }

}
