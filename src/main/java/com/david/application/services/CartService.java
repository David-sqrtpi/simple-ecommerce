package com.david.application.services;

import com.david.application.entity.Cart;
import com.david.application.entity.ItemDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;

@Service
public class CartService {

    @Autowired
    ProductService productService;

    private final ArrayList<Cart> carts = new ArrayList<>();

    public void createCard(Cart cart) {
        carts.add(cart);
    }

    public Iterator<Cart> getAll() {
        return carts.iterator();
    }

    public void addItem(String cartUuid, String productUuid, int quantity) {
        ItemDetail itemDetail = new ItemDetail(productService.getByUuid(productUuid), quantity);
        try {
            Cart cart = getCartByUuid(cartUuid);
            cart.addItem(itemDetail);
            cart.setTotal(cart.getTotal() +itemDetail.getSubtotal());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public String getTotal(String uuid) {
        return "Total is: ";
    }

    public String removeItem(String uuid) {
        return "Item with uuid: removed";
    }

    private Cart getCartByUuid(String uuid) {
        if(existsByUuid(uuid)){
            for(Cart cart : carts) {
                if(cart.getUuid().equals(uuid)) {
                    return cart;
                }
            }
        }

        return null;
    }

    private boolean existsByUuid(String uuid) {
        return carts.stream().anyMatch(cart -> cart.getUuid().equals(uuid));
    }


    public Cart getOne(String uuid) {
        if(existsByUuid(uuid)){
            for(Cart cart : carts) {
                if(cart.getUuid().equals(uuid)) {
                    return cart;
                }
            }
        }

        return null;
    }
}
