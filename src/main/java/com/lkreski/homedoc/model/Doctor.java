package com.lkreski.homedoc.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Data
@Entity
@Table(name= "doctor")
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int did;
    @OneToOne
    @JoinColumn(name="user_id")
    private User user;
    @NotEmpty
    @Column(name = "phonenumber")
    String phonenumber;
    @Column(name = "specialization")
    String specialization;
    @Column(name = "diploma")
    String diploma;
    @Column(name = "city")
    String city;
    @JoinColumn
    @Column(name = "verified")
    Boolean verified;
}
