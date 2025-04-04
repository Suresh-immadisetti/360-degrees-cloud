package com.example.librarymanagement.dto;

import java.io.Serializable;

public class BorrowRequestDTO implements Serializable {
    private Long userId;
    private Long bookId;

    // ✅ Default constructor
    public BorrowRequestDTO() {}

    // ✅ Parameterized constructor
    public BorrowRequestDTO(Long userId, Long bookId) {
        this.userId = userId;
        this.bookId = bookId;
    }

    // ✅ Getters
    public Long getUserId() {
        return userId;
    }

    public Long getBookId() {
        return bookId;
    }

    // ✅ Setters
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    // ✅ toString() for debugging
    @Override
    public String toString() {
        return "BorrowRequestDTO{" +
                "userId=" + userId +
                ", bookId=" + bookId +
                '}';
    }
}
