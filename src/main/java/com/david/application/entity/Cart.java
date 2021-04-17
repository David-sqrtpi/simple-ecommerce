package com.david.application.entity;

import com.david.application.enums.CartStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Cart {

    @Id
    private String uuid = UUID.randomUUID().toString();

    @OneToMany(mappedBy="cart", cascade = CascadeType.ALL)
    private List<Item> items = new ArrayList<>();

    private CartStatus cartStatus = CartStatus.PENDING;
    private long total;

    public void addItem(Item item) {
        items.add(item);
        item.setCart(this);
    }

    public void removeItem(Item item) {
        items.remove(item);
        item.setCart(null);
    }
}