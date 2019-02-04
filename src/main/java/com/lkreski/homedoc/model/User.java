package com.lkreski.homedoc.model;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.Set;

@Data
@Entity
@Table(name = "usersss")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private int id;
    @Column(name = "email")
    @Email(message = "*Należy podać poprawny adres Email")
    @NotEmpty(message = "*Należy podrać adres Email")
    private String email;
    @Column(name = "password")
    @Length(min = 5, message = "*Hasło musi się składać z conajmniej 5 znaków")
    @NotEmpty(message = "*Należy podać hasło")
    private String password;
    @Column(name = "name")
    @NotEmpty(message = "*Należy podać imię")
    private String name;
    @Column(name = "last_name")
    @NotEmpty(message = "*Należy podać nazwisko")
    private String lastName;
    @Column(name = "active")
    private int active;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
    private Doctor doctor;
}
