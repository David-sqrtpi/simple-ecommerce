package com.david.application.services;

import com.david.application.entity.Cart;
import com.david.application.entity.Item;
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

        Cart cart = getOne(cartUuid);

        if (hasProduct(cartUuid, productSku)) {
            itemService.changeItem(productSku, productQuantity, cart);
        } else {
            itemService.buildItem(productSku, productQuantity, cart);
        }

        changeTotal(cartUuid);
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

    private boolean isCartChecked(Cart cart){
        return cart.getCartStatus().equals(CartStatus.COMPLETED);
    }

    private boolean hasProduct(String cart, String product) {

        List<Item> items = itemService.findByCartUuid(cart);
        return items.stream().anyMatch(item -> item.getProduct().getSku().equals(product));
    }

    private void changeTotal(String cart) {
        long total = 0;

        List<Item> items = itemService.findByCartUuid(cart);

        System.out.println(items.size());
        for (Item item : items){
            total += item.getSubtotal();
        }

        Cart cart1 = getOne(cart);
        cart1.setTotal(total);
    }

}
