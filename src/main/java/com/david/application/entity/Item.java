package com.david.application.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Item {
    private final String uuid = UUID.randomUUID().toString();
    private int quantity;
    private Product product;
    private String productUuid;
}
