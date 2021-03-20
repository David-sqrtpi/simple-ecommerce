package com.david.application.services;

import com.david.application.entity.Cart;
import com.david.application.entity.Item;
import com.david.application.entity.Product;
import org.springframework.stereotype.Service;

@Service
public class ItemService {

    public void addItem(Cart cart, Product product, int quantity) {
        Item item = new Item(product, quantity);
        cart.setTotal(cart.getTotal() + item.getSubtotal());
        cart.addItem(item);
    }

    public void removeItem(String uuid) {

    }

    public void modifyItem(String uuid) {

    }
}
