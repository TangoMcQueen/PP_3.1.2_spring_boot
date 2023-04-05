package com.ez.spring.model;


import com.ez.spring.model.validator.CheckEmail;
import jakarta.persistence.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;
    @Column
    @Size(min = 2, max = 15, message = "Name must be min 2 symbols")
    @NotBlank(message = "Name should not be empty")
    private String name;
    @Column
    @Size(min = 2, max = 25, message = "Surname must be min 2 symbols")
    @NotBlank(message = "Surname should not be empty")
    private String surname;
    @Column
    @Size(min = 7, max = 40, message = "Email must be min 7 symbols")
    @CheckEmail
    private String email;

    public User() {
    }
    public User(String name, String surname, String email) {
        this.name = name;
        this.surname = surname;
        this.email = email;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}