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
    private final List<Product> products = new ArrayList<>();
    private long total;

    public void addProduct(Product product){
        this.products.add(product);
    }

    public void removeItem(Product product) {
        this.products.remove(product);
    }

    public void findItem(String productUuid) {

    }
}
