package com.david.application;

import com.david.application.entity.Cart;
import com.david.application.entity.ItemDetail;
import com.david.application.entity.Product;
import com.david.application.enums.ProductType;
import com.david.application.services.CartService;
import com.david.application.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class SimpleEcommerceApplication {

    @PostConstruct
    public void createCart() {
        Cart cart = new Cart();
        cart.setItems(new ArrayList<>());
    }

    @PostConstruct
    public void starterProducts() {
        List<Product> products = Stream.of(
                //new Product("name", 123, "description", 123, ProductType.SIMPLE)//,
                //new Product("Pintura", 100000, "Descripcion de pintura", 123, ProductType.SIMPLE)//,
                new Product("Cemento", 200000, "Description de cemento", 123, ProductType.DISCOUNT, "asd")
        ).collect(Collectors.toList());
    }

    public static void main(String[] args) {
        SpringApplication.run(SimpleEcommerceApplication.class, args);
    }

}
