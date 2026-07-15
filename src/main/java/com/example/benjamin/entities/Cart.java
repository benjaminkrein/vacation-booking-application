package com.example.benjamin.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "carts")
@Getter
@Setter

public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // id: Long
    @Column(name = "cart_id")
    private Long id;

    // orderTrackingNumber: String
    @Column(name = "order_tracking_number")
    private String orderTrackingNumber;

    // package_price: BigDecimal
    @Column(name = "package_price")
    private BigDecimal package_price;

    // party_size: int
    @Column(name = "party_size")
    private int party_size;

    // status: StatusType
    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private StatusType status;

    // create_date: Date
    @Column(name = "create_date")
    @CreationTimestamp
    private Date create_date;

    // last_update: Date
    @Column(name = "last_update")
    @UpdateTimestamp
    private Date last_update;

    // customer: Customer
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    // cartItems: Set<CartItem>
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cart")
    private Set<CartItem> cartItems = new HashSet<CartItem>();

    // adding cart item
    public void add(CartItem item) {
        if (item != null) {
            if (cartItems == null) {
                cartItems = new HashSet<>();
            }
            cartItems.add(item);
            item.setCart(this);
        }
    }
}
