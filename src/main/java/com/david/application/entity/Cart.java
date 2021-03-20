package com.david.application.entity;

import com.david.application.enums.CartStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cart {

    private final String uuid = UUID.randomUUID().toString();
    private CartStatus cartStatus = CartStatus.PENDING;
    private ArrayList<ItemDetail> items = new ArrayList<>();
    private long total;

    public void addItem(ItemDetail itemDetail){
        this.items.add(itemDetail);
    }

    public void removeItem(ItemDetail itemDetail) {
        this.items.remove(itemDetail);
    }
}
