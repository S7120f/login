package com.login.login.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // olika id i ordning, nytt genererat id per ny användare.
    private int id; // primarykey 
    private String firstName;
    private String lastName;
    private String email;
    private String username; 
    private String password; 

    
}
