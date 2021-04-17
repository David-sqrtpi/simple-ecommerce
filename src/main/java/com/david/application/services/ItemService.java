package com.david.application.services;

import com.david.application.entity.Item;
import com.david.application.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemService {

    @Autowired
    private ProductService productService;

    @Autowired
    private ItemRepository itemRepository;

    public Item buildItem(String sku, int quantity){

        return new Item(productService.getOne(sku), quantity);
    }

    public Item changeItem(String product, int quantity) {

        Item item = itemRepository.findByProductSku(product);
        item.setSubtotal(item.getSubtotal() + (item.getSubtotal()/item.getQuantity()) * quantity);
        item.setQuantity(item.getQuantity() + quantity);

        return item;
    }
}
