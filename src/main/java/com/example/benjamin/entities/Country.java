package com.example.benjamin.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "countries")
@Getter
@Setter

public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // id: Long
    @Column (name = "country_id")
    private Long id;

    // country_name: String
    @Column (name = "country")
    private String country_name;

    // create_date Date
    @Column (name = "create_date")
    @CreationTimestamp
    private Date create_date;

    // last_update Date
    @Column (name = "last_update")
    @UpdateTimestamp
    private Date last_update;

    // divisions: Set<Division>
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "country", fetch = FetchType.LAZY)
    private Set<Division> divisions;

}
