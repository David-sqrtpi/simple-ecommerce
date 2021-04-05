package com.david.application.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    private Product product;

    private int quantity;
    private long subtotal;

    public Item(Product product, int quantity){
        this.setSubtotal(product.getPrice()*quantity);
        this.setProduct(product);
        this.setQuantity(quantity);
    }
}
