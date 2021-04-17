package com.david.application.entity;

import com.david.application.enums.ProductType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Product {

    @Id
    private String uuid = UUID.randomUUID().toString();

    @Column(unique = true, nullable = false)
    private String sku;

    private String name;
    private long price;

}
