package com.david.application.entity;

import com.david.application.enums.ProductType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Product {

    private String name;
    private long sku;
    private String description;
    private long price;
    private ProductType productType;

    @Id
    private String uuid;

}
