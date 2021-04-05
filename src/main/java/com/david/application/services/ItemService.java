package com.david.application.services;

import com.david.application.entity.Item;
import com.david.application.entity.Product;
import com.david.application.repository.ItemRepository;
import com.david.application.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ItemRepository itemRepository;

    public Item buidItem(String sku, int quantity){

        Item item = new Item(findProduct(sku), quantity); //TODO Using non-optional return method

        save(item);

        return item;
    }

    private Product findProduct(String sku){
        return productRepository.findBySku(sku);
    }

    private void save(Item item){
        itemRepository.save(item);
    }
}
