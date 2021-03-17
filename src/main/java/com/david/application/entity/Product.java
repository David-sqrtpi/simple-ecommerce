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

    private String name, description, uuid;

    private int price;

    private long sku;
}
