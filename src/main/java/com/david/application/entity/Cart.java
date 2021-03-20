package com.david.application.entity;

import com.david.application.enums.CartStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cart {

    private final String uuid = UUID.randomUUID().toString();
    private CartStatus cartStatus = CartStatus.PENDING;
    private Map<String, Item> items = new HashMap<>();
    private long total;

    public void addItem(Item item){
        this.items.put(item.getUuid(), item);
    }

    public void removeItem(Item item) {
        this.items.remove(item.getUuid());
    }
}
