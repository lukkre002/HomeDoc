package com.lkreski.homedoc.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name= "doctor")
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "did")
    Integer did;
    @Column(name = "firstname")
    String firstname;
    @Column(name = "surname")
    String surname;
    @Column(name = "email")
    String email;
    @Column(name = "phonenumber")
    String phonenumber;
    @Column(name = "specialization")
    String specialization;
    @Column(name = "diploma")
    String diploma;
    @Column(name = "verified")
    Boolean verified;
    @Column(name = "city")
    String city;
}
