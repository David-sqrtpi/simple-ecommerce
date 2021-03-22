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

/*
This class is used to construct the cartDTO, it allows to show a more human-readable JSON
*/
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
                items.put(product.getUuid(), 1);
            } else {
                System.out.println("else");
                items.put(product.getUuid(), items.get(product.getUuid()) + 1);
            }

        }

        return prettier(items);
    }

    private List<Item> prettier(HashMap<String, Integer> items) {
        List<Item> pItem = new ArrayList<>();
        for (String uuid : items.keySet()){
            Item item = new Item();
            item.setProductUuid(uuid);
            item.setProduct(productService.getOne(uuid));
            item.setQuantity(items.get(uuid));
            pItem.add(item);
        }
        return pItem;
    }
}
