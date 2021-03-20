package com.david.application.services;

import com.david.application.entity.Cart;
import com.david.application.entity.Item;
import com.david.application.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemService {

    @Autowired
    private ProductService productService;

    @Autowired
    private CartService cartService;

    public void addItem(String cartUuid, String productUuid, int quantity) {

        Product product = productService.getOne(productUuid);
        Cart cart = cartService.getOne(cartUuid);
        Item item = new Item(product, quantity);
        cart.setTotal(cart.getTotal() + item.getSubtotal());

        cart.addItem(item);
    }

    public void removeItem(String uuid) {

    }

    public void modifyItem(String uuid) {

    }
}
