package com.david.application.entity;

import com.david.application.enums.CartState;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.util.ArrayList;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cart {

    private String uuid;
    private ArrayList<Product> products;
    private CartState cartState;

}
