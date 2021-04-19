package com.david.application;

import com.david.application.entity.Cart;
import com.david.application.entity.Item;
import com.david.application.entity.Product;
import com.david.application.enums.CartStatus;
import com.david.application.repository.CartRepository;
import com.david.application.repository.ItemRepository;
import com.david.application.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.ArrayList;

@SpringBootApplication
public class SimpleEcommerceApplication {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CartRepository cartRepository;

    public static void main(String[] args) {
        SpringApplication.run(SimpleEcommerceApplication.class, args);
    }

    @PostConstruct
    public void init(){
        Product product = new Product("UUID", "1", "Producto 1", 1000);
        productRepository.save(product);

        Cart cart = new Cart("UUID", new ArrayList<>(), CartStatus.PENDING, 0);

        cartRepository.save(cart);
    }
}
