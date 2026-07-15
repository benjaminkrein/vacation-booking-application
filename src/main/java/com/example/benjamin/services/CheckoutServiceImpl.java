package com.example.benjamin.services;

import com.example.benjamin.dao.CartItemRepository;
import com.example.benjamin.dao.CartRepository;
import com.example.benjamin.dao.CustomerRepository;
import com.example.benjamin.entities.Cart;
import com.example.benjamin.entities.CartItem;
import com.example.benjamin.entities.Customer;
import com.example.benjamin.entities.StatusType;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.UUID;

@Service
public class CheckoutServiceImpl implements CheckoutService {
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private CartItemRepository cartItemRepository;

    public CheckoutServiceImpl(CustomerRepository customerRepository, CartRepository cartRepository,
                               CartItemRepository cartItemRepository) {
        this.customerRepository = customerRepository;
        this.cartRepository = cartRepository;
        this.cartItemRepository = cartItemRepository;
    }
    @Override
    @Transactional
    public PurchaseResponse placeOrder (Purchase purchase) {
        // retrieve cart info
        Cart cart = purchase.getCart();
        Customer customer = purchase.getCustomer();
        Set<CartItem> cartItems = purchase.getCartItems();

        // generate tracking number
        String orderTrackingNumber = generateOrderTrackingNumber();
        cart.setOrderTrackingNumber(orderTrackingNumber);

        // populate cart with cartItems
        cartItems.forEach(cartItem -> cart.add(cartItem));

        // link cart to customer
        customer.add(cart);

        //set cart status to ordered
        cart.setStatus(StatusType.ordered);

        // save to the database
        customerRepository.save(customer);

        // return a response
        return new PurchaseResponse(orderTrackingNumber);
    }

    private String generateOrderTrackingNumber() {
        // generate a random UUID number
        return UUID.randomUUID().toString();
    }


}
