package com.example.librarymanagement.model;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    public User() {}

    public User(String name) { this.name = name; }

    public Long getId() { return id; }
    public String getName() { return name; }
}