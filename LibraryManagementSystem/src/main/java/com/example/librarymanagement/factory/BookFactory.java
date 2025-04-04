package com.example.librarymanagement.factory;

import com.example.librarymanagement.model.Book;

public class BookFactory {
    public static Book createBook(String title, String author) {
        return new Book(title, author); // ✅ Uses the corrected constructor
    }
}
