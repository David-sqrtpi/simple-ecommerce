package com.david.application.services;

import com.david.application.entity.Item;
import com.david.application.entity.Product;
import com.david.application.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemService {

    @Autowired
    private ProductService productService;

    @Autowired
    private ItemRepository itemRepository;

    public Item buidItem(String sku, int quantity){

        Item item = new Item(productService.getOne(sku), quantity);

        save(item);

        return item;
    }

    public Item changeItem(String product, int quantity) {
        Product product1 = productService.getOne(product);
        Item item = itemRepository.findByProductSku(product);
        item.setQuantity(item.getQuantity() + quantity);
        item.setSubtotal(item.getSubtotal() + product1.getPrice() * quantity);
        save(item);
        return item;
    }

    private void save(Item item){
        itemRepository.save(item);
    }
}
