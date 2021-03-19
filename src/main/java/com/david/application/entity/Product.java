package com.david.application.entity;

import com.david.application.enums.ProductType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    private String name;
    private long sku;
    private String description;
    private int price;
    private ProductType productType;

    @Id
    private final String uuid = UUID.randomUUID().toString();

}
