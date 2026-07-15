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
@Table(name = "divisions")
@Getter
@Setter

public class Division {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // id: Long
    @Column(name = "division_id")
    private Long id;

    // division_name: String
    @Column(name = "division")
    private String division_name;

    // create_date: Date
    @Column(name = "create_date")
    @CreationTimestamp
    private Date create_date;

    // last_update: Date
    @Column(name = "last_update")
    @UpdateTimestamp
    private Date last_update;

    //ManytoOne country: Country
    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "country_id", nullable = false, insertable = false, updatable = false)
    private Country country;

    // country_id: Long
    @Column(name = "country_id")
    private Long country_id;

    public void setCountry(Country country) {
        setCountry_id(country.getId());
        this.country = country;
    }

    //OnetoMany customers: Set<Customer>
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "division", fetch = FetchType.LAZY)
    private Set<Customer> customers = new HashSet<>();

}
