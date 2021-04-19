package com.david.application.entity;

import com.david.application.enums.CartStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Cart {
    @Id
    private String uuid = UUID.randomUUID().toString();

    private CartStatus cartStatus = CartStatus.PENDING;
    private long total;
}