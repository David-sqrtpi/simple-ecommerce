package com.david.application.services;

import com.david.application.entity.Cart;
import com.david.application.entity.Item;
import com.david.application.entity.Product;
import com.david.application.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {

    @Autowired
    private ProductService productService;

    @Autowired
    private ItemRepository itemRepository;

    public void buildItem(String sku, int quantity, Cart cart){
        Product product = productService.getOne(sku);
        long subtotal = product.getPrice()*quantity;

        Item item = new Item(0, cart, product, quantity, subtotal);

        itemRepository.save(item);
    }

    public Item changeItem(String product, int quantity, Cart cart) {
        Product product1 = productService.getOne(product);

        Item item = itemRepository.findByProductSku(product); //TODO think about items who have the same product but in different carts
        item.setQuantity(item.getQuantity() + quantity);
        item.setSubtotal(product1.getPrice() * item.getQuantity());

        itemRepository.save(item);

        return item;
    }

    public List<Item> findByCartUuid(String cart){
        return itemRepository.findByCartUuid(cart);
    }
}
