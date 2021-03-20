package com.david.application.services;

import com.david.application.entity.Cart;
import com.david.application.entity.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemService {

    @Autowired
    private ProductService productService;

    public void addItem(Cart cart, String productUuid, int quantity) {
        cart.addItem(new Item(productService.getOne(productUuid), quantity));
    }

    public void removeItem(String uuid) {

    }

    public void modifyItem(String uuid) {

    }
}
