package com.example.benjamin.services;

import com.example.benjamin.entities.Cart;
import com.example.benjamin.entities.CartItem;
import com.example.benjamin.entities.Customer;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class Purchase {

    private Customer customer;
    private Cart cart;
    private Set<CartItem> cartItems;

}
