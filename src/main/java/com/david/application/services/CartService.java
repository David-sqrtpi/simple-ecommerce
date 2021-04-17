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

    public Cart getOne(String uuid) {
        return cartRepository.findByUuid(uuid);//TODO determine why using getOne() throws an exception
    }

    public Cart createCart() {
        return cartRepository.save(new Cart());
    }

    public void addItem(String cartUuid, String productSku, int productQuantity) {

        if (!cartRepository.existsById(cartUuid)){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "This car does not exists");
        }

        Cart cart = cartRepository.getOne(cartUuid);

        if (hasProduct(cart, productSku)) {
            cart.getItems().add(itemService.changeItem(productSku, productQuantity));
            //cartRepository.save(cart);
            /*TODO change from add item to cart to assign cart to item
             *  because JPA generates a intermediate table called cart_items*/

            /*TODO search about database normalization to define if using a intermediate
            *  table for one-to-many relationships is either correct or recommended*/

        } else {
            cart.getItems().add(itemService.buidItem(productSku, productQuantity));
            cartRepository.save(cart);
        }

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

    private boolean isCartChecked(Cart cart){
        return cart.getCartStatus().equals(CartStatus.COMPLETED);
    }

    private boolean hasProduct(Cart cart, String product) {

        return cart.getItems()
                .stream()
                .anyMatch(item ->
                        item.getProduct().getSku().equals(product)
                );
    }

}
