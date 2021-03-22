package com.david.application.DTO;

import com.david.application.entity.Item;
import com.david.application.enums.CartStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartDTO implements Serializable {

    private String uuid;
    private CartStatus cartStatus;
    private List<Item> items = new ArrayList<>();
    private long total;

}
