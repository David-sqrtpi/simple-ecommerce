package com.david.application.services;

import com.david.application.entity.Cart;
import com.david.application.entity.Item;
import com.david.application.enums.CartStatus;
import com.david.application.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ItemService itemService;

    public List<Cart> findAll() {
        return cartRepository.findAll();
    }

    public Cart getOne(String uuid) {
        return cartRepository.findByUuid(uuid);//TODO determine why using getOne() throws an exception
    }

    public Cart createCart() {
        return cartRepository.save(new Cart());
    }

    public void addItem(String cartUuid, String productSku, int productQuantity) {

        if (!cartRepository.existsById(cartUuid)){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "This car does not exists");
        }

        Cart cart = getOne(cartUuid);

        if (hasProduct(cart, productSku)) {
            cart.addItem(itemService.changeItem(productSku, productQuantity));
        } else {
            cart.addItem(itemService.buildItem(productSku, productQuantity));
        }

        changeTotal(cart);
        cartRepository.save(cart);

        throw new ResponseStatusException(HttpStatus.CREATED, "Item has been added");
    }

    public void removeItem(String cartUuid, String product) {
        Cart cart = cartRepository.getOne(cartUuid);
        if(!isCartChecked(cart)){
            System.out.println("do some stuff");
        }
    }

    public String check(String cartUuid) {
        Cart cart = cartRepository.getOne(cartUuid);
        if(isCartChecked(cart)){
            return "This cart was checked already";
        }
        cart.setCartStatus(CartStatus.COMPLETED);
        cartRepository.save(cart);
        return "Total is: " + cart.getTotal();
    }

    private boolean isCartChecked(Cart cart){
        return cart.getCartStatus().equals(CartStatus.COMPLETED);
    }

    private boolean hasProduct(Cart cart, String product) {

        return cart.getItems()
                .stream()
                .anyMatch(item ->
                        item.getProduct().getSku().equals(product)
                );
    }

    private void changeTotal(Cart cart) {
        long total = 0;

        System.out.println(cart.getItems().size());
        for (Item item : cart.getItems()){
            total += item.getSubtotal();
            System.out.println("Item id: " + item.getId() + "\n");
            System.out.println("Item name: " + item.getProduct().getName() + "\n");
            System.out.println("Item subtotal: " + item.getSubtotal() + "\n");
            System.out.println("Cart total: " + total + "\n");
        }

        cart.setTotal(total);
    }

}
