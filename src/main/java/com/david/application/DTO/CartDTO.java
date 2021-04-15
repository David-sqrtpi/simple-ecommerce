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
    private String cartStatus;
    private List<String> items = new ArrayList<>();
    private long total;

}
