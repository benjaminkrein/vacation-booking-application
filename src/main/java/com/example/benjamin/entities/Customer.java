package com.example.benjamin.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "customers")
@Getter
@Setter

public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // id: Long
    @Column(name = "customer_id")
    private Long id;

    // firstName: String
    @Column(name = "customer_first_name", nullable = false)
    private String firstName;

    // lastName: String
    @Column(name = "customer_last_name", nullable = false)
    private String lastName;

    // address: String
    @Column(name = "address", nullable = false)
    private String address;

    // postal_code: String
    @Column(name = "postal_code", nullable = false)
    private String postal_code;

    // phone: String
    @Column(name = "phone", nullable = false)
    private String phone;

    // create_date: Date
    @Column(name = "create_date")
    @CreationTimestamp
    private Date create_date;

    // last_update: Date
    @Column(name = "last_update")
    @UpdateTimestamp
    private Date last_update;

    // division: Division
    @ManyToOne
    @JoinColumn(name = "division_id")
    private Division division;

    // carts: Set<Cart>
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customer")
    private Set<Cart> carts = new HashSet<>();

    public void add(Cart cart) {
        if (cart != null) {
            if (carts == null) {
                carts = new HashSet<>();
            }
        }
        carts.add(cart);
        cart.setCustomer(this);
    }
}
