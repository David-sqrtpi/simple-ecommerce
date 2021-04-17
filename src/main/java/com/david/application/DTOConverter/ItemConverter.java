package com.david.application.DTOConverter;

import com.david.application.DTO.ItemDTO;
import com.david.application.entity.Item;
import com.david.application.util.DTOConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemConverter implements DTOConverter<Item, ItemDTO> {

    @Autowired
    private ProductConverter productConverter;

    @Override
    public Item fromDTO(ItemDTO DTO) {
        Item item = new Item();

        item.setSubtotal(DTO.getSubtotal());
        item.setProduct(productConverter.fromDTO(DTO.getProductDTO()));
        item.setQuantity(DTO.getQuantity());

        return item;
    }

    @Override
    public ItemDTO fromEntity(Item entity) {
        ItemDTO itemDTO = new ItemDTO();

        itemDTO.setSubtotal(entity.getSubtotal());
        itemDTO.setProductDTO(productConverter.fromEntity(entity.getProduct()));
        itemDTO.setQuantity(entity.getQuantity());

        return itemDTO;
    }
}
