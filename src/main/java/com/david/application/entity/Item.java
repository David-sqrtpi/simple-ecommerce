package com.david.application.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Item {

    private String uuid = UUID.randomUUID().toString();
    private Product product;
    private int quantity;
    private long subtotal;

    public Item(Product product, int quantity) {
        this.setQuantity(quantity);
        this.setProduct(product);
        this.subtotal = this.product.getPrice() * quantity;
    }

}
