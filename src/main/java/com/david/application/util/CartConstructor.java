package com.david.application.util;


import com.david.application.DTO.CartDTO;
import com.david.application.entity.Cart;
import com.david.application.entity.Item;
import com.david.application.entity.Product;
import com.david.application.services.CartService;
import com.david.application.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CartConstructor {
    @Autowired
    private CartService cartService;

    @Autowired
    private ProductService productService;

    public CartDTO construct(String uuid) {

        Cart cartDb = cartService.getOne(uuid);

        return new CartDTO(cartDb.getUuid(),
                cartDb.getCartStatus(),
                arrangeProducts(cartDb.getProducts()),
                cartDb.getTotal());
    }

    private List<Item> arrangeProducts(List<Product> products) {
        HashMap<String, Integer> items = new HashMap<>();

        for(Product product : products){
            if(!items.containsKey(product.getUuid())){
                items.put(product.getUuid(), 0);
            } else {
                items.put(product.getUuid(), items.get(product.getUuid()) + 1);
            }

        }

        return pretier(items);
    }

    private List<Item> pretier(HashMap<String, Integer> items) {
        List<Item> pItem = new ArrayList<>();
        for (String uuid : items.keySet()){
            Item item = new Item();
            item.setProductUuid(uuid);
            item.setQuantity(items.get(uuid));
            pItem.add(item);
        }
        return pItem;
    }
}
