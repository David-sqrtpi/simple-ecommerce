package com.david.application.repository;

import com.david.application.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {
    Product findBySku(String productSku);

    boolean existsBySku(String sku);

    @Transactional
    void deleteBySku(String sku);

    Product getOneBySku(String sku);
}
