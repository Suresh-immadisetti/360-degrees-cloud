package com.example.librarymanagement.strategy;

import com.example.librarymanagement.model.Book;

public interface BorrowStrategy {
    void borrow(Book book);
}
