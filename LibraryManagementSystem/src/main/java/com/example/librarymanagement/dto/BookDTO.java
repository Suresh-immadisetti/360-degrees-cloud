package com.example.librarymanagement.dto;

import java.io.Serializable;

public class BookDTO implements Serializable {
    private String title;
    private String author;

    // ✅ Default constructor
    public BookDTO() {}

    // ✅ Parameterized constructor
    public BookDTO(String title, String author) {
        this.title = title;
        this.author = author;
    }

    // ✅ Getters
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    // ✅ Setters
    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    // ✅ toString() for debugging
    @Override
    public String toString() {
        return "BookDTO{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
