package com.david.application.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartDTO {

    private String uuid;
    private String cartStatus;
    private List<ItemDTO> itemDTOS = new ArrayList<>();
    private long total;

}