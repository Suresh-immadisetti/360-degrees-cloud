package com.example.librarymanagement.model;

import jakarta.persistence.*;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String author;
    private boolean available = true;

    @ManyToOne
    private User borrowedBy; // Track which user borrowed the book

    // ✅ Constructor used by BookFactory
    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.available = true;
    }

    // ✅ Default constructor (JPA requirement)
    public Book() {}

    // ✅ Getters and Setters
    public Long getId() { return id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }

    public boolean isAvailable() { return available; }
    public void setAvailable(boolean available) { this.available = available; }

    public User getBorrowedBy() { return borrowedBy; }
    public void setBorrowedBy(User borrowedBy) { this.borrowedBy = borrowedBy; }
}
