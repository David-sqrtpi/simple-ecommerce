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

    @ManyToMany
    private final List<Product> products = new ArrayList<>();

    private CartStatus cartStatus = CartStatus.PENDING;
    private long total;

    public void addProduct(Product product){
        this.products.add(product);
    }

    public void removeProduct(String productUuid) {
        this.products.removeIf(product -> product.getUuid().equals(productUuid));
    }
}
