package com.david.application.services;

import com.david.application.entity.Cart;
import com.david.application.entity.Item;
import com.david.application.entity.Product;
import com.david.application.enums.CartStatus;
import com.david.application.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ProductService productService;

    public void createCart(Cart cart) {
        cartRepository.save(cart);
    }

    public List<Cart> getAll() {
        return cartRepository.findAll();
    }

    public ResponseEntity<String> addItem(String cartUuid, Item item) {
        if (!exists(cartUuid)) {
            return new ResponseEntity<>("This car does not exists",
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
        Cart cart = cartRepository.getOne(cartUuid);
        Product product = productService.getOne(item.getProductUuid());
        if (product == null) {
            return new ResponseEntity<>("This product does not exists",
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
        for (int i = 0; i < item.getQuantity(); i++) {
            cart.addProduct(product);
        }
        changeTotal(cart);
        cartRepository.save(cart);
        return new ResponseEntity<>("Success",
                HttpStatus.OK);
    }

    public void removeItem(String cartUuid, Item item) {
        Cart cart = cartRepository.getOne(cartUuid);
        if (cart.getProducts() != null) {
            cart.removeProduct(item.getProductUuid());
            changeTotal(cart);
            cartRepository.save(cart);
        }
    }

    public String check(String cartUuid) {
        Cart cart = cartRepository.getOne(cartUuid);
        if(isCompleted(cart)){
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

    private boolean isCompleted(Cart cart){
        return cart.getCartStatus().equals(CartStatus.COMPLETED);
    }

    private void changeTotal(Cart cart) {
        cart.setTotal(0);
        for (Product product : cart.getProducts()) {
            cart.setTotal(product.getPrice() + cart.getTotal());
        }
    }
}
