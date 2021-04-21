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
        long subtotal = product.getPrice() * quantity;

        Item item = new Item(0, cart, product, quantity, subtotal);

        itemRepository.save(item);
    }

    public void changeItem(String product, int quantity, String cart) {

        Item item = itemRepository.findByProductSkuAndCartUuid(product, cart);
        item.setQuantity(item.getQuantity() + quantity);
        item.setSubtotal(item.getQuantity() * item.getProduct().getPrice());
        itemRepository.save(item);
    }

    public void changeSubtotal(String product) {
        List<Item> items = itemRepository.findByProductSku(product);
        for (Item item:items){
            item.setSubtotal(item.getProduct().getPrice() * item.getQuantity());
        }
        itemRepository.saveAll(items);
    }

    public List<Item> findByCartUuid(String cart){
        return itemRepository.findByCartUuid(cart);
    }
}
