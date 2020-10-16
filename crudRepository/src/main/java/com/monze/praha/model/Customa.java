package com.monze.praha.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

// HIBERNATE STAFFS!
@Entity
@Table(name = "CUSTOMALIST")
public class Customa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "first_name") // Capital letters = small letters+underscore!
    private String firstName;
    @Column(name = "last_name", nullable = false, length = 80)
    private String lastName;
    @Column(name = "email", nullable = false, length = 80)
    private String email;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        // firstName= firstName.toUpperCase();
        return firstName;
    }

    public void setFirstName(String firstName) {
        // firstName= firstName.toUpperCase();
        this.firstName = firstName;
    }

    public String getLastName() {
        // lastName= lastName.toUpperCase();
        return lastName;
    }

    public void setLastName(String lastName) {
        // lastName= lastName.toUpperCase();
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}