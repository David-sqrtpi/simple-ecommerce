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

    public Item buildItem(String sku, int quantity){
        Item item = new Item();
        Product product = productService.getOne(sku);
        item.setProduct(product);
        item.setQuantity(quantity);
        item.setSubtotal(product.getPrice()*quantity);
        return item;
    }

    public Item changeItem(String product, int quantity) {
        Product product1 = productService.getOne(product);
        long addToSubtotal = product1.getPrice() * quantity;

        Item item = itemRepository.findByProductSku(product); //TODO think about items who have the same product but in different carts
        item.setSubtotal(item.getSubtotal() + addToSubtotal);
        item.setQuantity(item.getQuantity() + quantity);

        itemRepository.save(item);

        return item;
    }
}
