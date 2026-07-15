package com.example.benjamin.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "excursions")
@Getter
@Setter

public class Excursion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // id: Long
    @Column(name = "excursion_id")
    private Long id;

    // excursion_title: String
    @Column(name = "excursion_title")
    private String excursion_title;

    // excursion_price: BigDecimal
    @Column(name = "excursion_price")
    private BigDecimal excursion_price;

    // image_URL: String
    @Column(name = "image_url")
    private String image_URL;

    // create_date: Date
    @Column(name = "create_date")
    @CreationTimestamp
    private Date create_date;

    // last_update: Date
    @Column(name = "last_update")
    @UpdateTimestamp
    private Date last_update;

    //ManytoOne vacation: Vacation
    @ManyToOne
    @JoinColumn(name = "vacation_id")
    private Vacation vacation;

    //ManytoMany cartitems: Set<CartItem>
    @ManyToMany(mappedBy = "excursions")
    private Set<CartItem> cartItems;

}
