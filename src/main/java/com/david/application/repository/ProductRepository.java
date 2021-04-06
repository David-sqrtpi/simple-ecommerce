package com.david.application.repository;

import com.david.application.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {
    Product findBySku(String productSku);

    boolean existsBySku(String uuid);

    void deleteBySku(String product);

}
