package com.david.application.repository;

import com.david.application.entity.Item;
import com.david.application.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item, String> {
    Item findByProductSku(String sku);
}
