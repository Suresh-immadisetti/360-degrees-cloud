package com.example.librarymanagement.strategy;

import com.example.librarymanagement.model.Book;

public class DefaultBorrowStrategy implements BorrowStrategy {
    @Override
    public void borrow(Book book) {
        if (book.isAvailable()) {
            book.setAvailable(false);
            System.out.println("Book borrowed successfully!");
        } else {
            System.out.println("Error: Book is already borrowed.");
        }
    }
}
