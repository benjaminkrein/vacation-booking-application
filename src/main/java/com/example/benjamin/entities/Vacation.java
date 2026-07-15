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
@Table(name = "vacations")
@Getter
@Setter

public class Vacation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // id: Long
    @Column(name = "vacation_id")
    private Long id;

    // vacation_title: String
    @Column(name = "vacation_title")
    private String vacation_title;

    // description: String
    @Column(name = "description")
    private String description;

    // travel_price: BigDecimal
    @Column(name = "travel_fare_price")
    private BigDecimal travel_price;

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

    //OnetoMany excursions: Set<Excursion>
    @OneToMany(mappedBy = "vacation")
    private Set<Excursion> excursions;
}
