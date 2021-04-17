package com.david.application.DTO;

import lombok.Data;


@Data
public class ItemDTO {
    private ProductDTO productDTO;
    private int quantity;
    private long subtotal;
}
