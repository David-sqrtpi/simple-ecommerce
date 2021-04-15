package com.david.application.DTOConverter;

import com.david.application.DTO.CartDTO;
import com.david.application.entity.Cart;
import com.david.application.enums.CartStatus;
import org.springframework.stereotype.Service;

@Service
public class CartConverter implements DTOConverter<Cart, CartDTO> {
    @Override
    public Cart fromDTO(CartDTO DTO) {
        Cart cart = new Cart();
        cart.setCartStatus(CartStatus.valueOf(DTO.getCartStatus()));
        cart.setTotal(DTO.getTotal());
        //TODO cart.setItems(DTO.getItems().stream().map());
        return cart;
    }

    @Override
    public CartDTO fromEntity(Cart entity) {
        CartDTO cartDTO = new CartDTO();
        cartDTO.setCartStatus(entity.getCartStatus().name());
        cartDTO.setTotal(entity.getTotal());
        //TODO cartDTO.setItems(entity.getItems().toString());
        return cartDTO;
    }
}
