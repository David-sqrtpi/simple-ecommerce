package com.david.application.repository;

import com.david.application.entity.Item;
import com.david.application.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item, String> {
    List<Item> findByProductSku(String sku);
    Item findByProductSkuAndCartUuid(String product, String cart);
    List<Item> findByCartUuid(String cart);
}
