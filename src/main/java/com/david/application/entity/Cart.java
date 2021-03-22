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
    private  String uuid;

    private CartStatus cartStatus = CartStatus.PENDING;
    @ManyToMany
    private final List<Item> items = new ArrayList<>();
    private long total;

    public void addItem(Item item){
        this.items.add(item);
    }

    public void removeItem(Item item) {
        this.items.remove(item);
    }
}
