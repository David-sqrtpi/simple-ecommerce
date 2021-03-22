package com.david.application;

import com.david.application.entity.Cart;
import com.david.application.entity.Product;
import com.david.application.enums.CartStatus;
import com.david.application.enums.ProductType;
import com.david.application.repository.CartRepository;
import com.david.application.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class SimpleEcommerceApplication {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CartRepository cartRepository;

    @PostConstruct
    public void starterProducts() {
        List<Product> products = Stream.of(
                new Product("Keyboard", 123, "description", 50000, ProductType.SIMPLE, "first"),
                new Product("Pintura", 234, "Descripcion de pintura", 100000, ProductType.SIMPLE, "second"),
                new Product("Cemento", 345, "Description de cemento", 200000, ProductType.DISCOUNT, "third")
        ).collect(Collectors.toList());

        productRepository.saveAll(products);
    }

    @PostConstruct
    public void starterCart() {
        Cart cart = new Cart("first", CartStatus.PENDING,0);
        cartRepository.save(cart);
    }


    public static void main(String[] args) {
        SpringApplication.run(SimpleEcommerceApplication.class, args);
    }

}
