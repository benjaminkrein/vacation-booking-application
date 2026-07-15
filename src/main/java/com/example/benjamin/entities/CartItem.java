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
@Table(name = "cart_items")
@Getter
@Setter

public class CartItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // id: Long
    @Column(name = "cart_item_id")
    private Long id;

    // ManytoOne vacation: vacation
    @ManyToOne
    @JoinColumn(name = "vacation_id")
    private Vacation vacation;

    // ManytoMany excursions: set<Excursion>
    @ManyToMany
    @JoinTable(name = "excursion_cartitem", joinColumns = @JoinColumn(name = "cart_item_id"), inverseJoinColumns = @JoinColumn(name = "excursion_id"))
    private Set<Excursion> excursions = new HashSet<Excursion>();

    // ManytoOne cart: Cart
    @ManyToOne
    @JoinColumn(name = "cart_id")
    private Cart cart;

    // create_date: Date
    @Column(name = "create_date")
    @CreationTimestamp
    private Date create_date;

    // last_update: Date
    @Column(name = "last_update")
    @UpdateTimestamp
    private Date last_update;

}
