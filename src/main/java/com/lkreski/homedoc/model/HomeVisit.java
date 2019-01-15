package com.lkreski.homedoc.model;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
@Data
@NoArgsConstructor
@Entity
@Table(name = "homevisit")
public class HomeVisit {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "city")
    private String city;
    @Column(name = "zipcode")
    private String zipcode;
    @Column(name = "street")
    private String street;
    @Column(name = "house")
    private String house;
    @Column(name = "flat")
    private String flat;


}
