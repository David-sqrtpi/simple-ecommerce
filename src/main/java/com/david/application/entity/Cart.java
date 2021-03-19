package com.david.application.entity;

import com.david.application.enums.CartStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.UUID;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cart {

    @Id
    private final String uuid = UUID.randomUUID().toString();
    private CartStatus cartStatus;
    private ArrayList<ItemDetail> items;
    private int total;

}
