package com.david.application.repository;

import com.david.application.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface ProductRepository extends JpaRepository<Product, String> {

    boolean existsByUuid(String uuid);

}
