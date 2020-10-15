package com.monze.praha.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

// HIBERNATE STAFFS!
@Entity
@Table(name = "CUSTOMERLIST")
public class Customa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Long id;
    @Column(name = "firstname")
    private String firstname;
    @Column(name = "lastname", nullable = false, length = 60)
    private String lastname;
    @Column(name = "email", nullable = false, length = 60)
    private String email;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname.toUpperCase();
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname.toUpperCase();
    }

    public String getLastname() {
        return lastname.toUpperCase();
    }

    public void setLastname(String lastname) {
        this.lastname = lastname.toUpperCase();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}