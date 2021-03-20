package com.david.application.entity;

import com.david.application.enums.ProductType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    private String name;
    private long sku;
    private String description;
    private long price;
    private ProductType productType;

    private String uuid;

    //TODO don't forget about discount products

}
