package com.david.application.services;

import com.david.application.entity.Cart;
import com.david.application.entity.ItemDetail;
import com.david.application.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CartService {

    @Autowired
    private ProductService productService;


    public void addItem(String uuid, int quantity) {

        Cart cart = new Cart();

        Product product = productService.getByUuid(uuid);

        ItemDetail itemDetail = new ItemDetail();

        itemDetail.setCartUuid(cart.getUuid());
        itemDetail.setProduct(product);
        itemDetail.setQuantity(quantity);

        ArrayList<ItemDetail> items = new ArrayList<>();

        items.add(itemDetail);
    }

    public String getTotal(String uuid) {
        return "Total is: ";
    }

    public String removeItem(String uuid) {
        return "Item with uuid : removed";
    }
}
