package com.david.application.DTOConverter;

import com.david.application.DTO.CartDTO;
import com.david.application.entity.Cart;
import com.david.application.entity.Item;
import com.david.application.enums.CartStatus;
import com.david.application.services.ItemService;
import com.david.application.util.DTOConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartConverter implements DTOConverter<Cart, CartDTO> {

    @Autowired
    private ItemConverter itemConverter;

    @Autowired
    private ItemService itemService;

    @Override
    public Cart fromDTO(CartDTO DTO) {
        Cart cart = new Cart();
        cart.setCartStatus(CartStatus.valueOf(DTO.getCartStatus()));
        cart.setTotal(DTO.getTotal());
        //cart.setItems(itemConverter.fromDTO(DTO.getItemDTOS()));
        cart.setUuid(DTO.getUuid());

        return cart;
    }

    @Override
    public CartDTO fromEntity(Cart entity) {
        CartDTO cartDTO = new CartDTO();
        cartDTO.setCartStatus(entity.getCartStatus().name());
        cartDTO.setTotal(entity.getTotal());
        List<Item> items = itemService.findByCartUuid(entity.getUuid()) ;
        cartDTO.setItemDTOS(itemConverter.fromEntity(items));
        cartDTO.setUuid(entity.getUuid());

        return cartDTO;
    }
}