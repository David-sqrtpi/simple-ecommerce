package com.david.application.entity;

import jdk.jfr.Enabled;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Enabled
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    private String name, sku, description;
    private int price;
}
