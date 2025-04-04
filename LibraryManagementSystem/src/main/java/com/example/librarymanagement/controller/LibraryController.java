package com.example.librarymanagement.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.librarymanagement.model.Book;
import com.example.librarymanagement.service.LibraryService;

@RestController
@RequestMapping("/library")
public class LibraryController {
    private final LibraryService libraryService;

    public LibraryController(LibraryService libraryService) {
        this.libraryService = libraryService;
    }

    @PostMapping("/addBook")
    public Book addBook(@RequestParam String title, @RequestParam String author) {
        return libraryService.addBook(title, author);
    }

    @PostMapping("/registerUser")
    public String registerUser(@RequestParam String name) {
        libraryService.registerUser(name);
        return "User registered successfully";
    }

    @GetMapping("/books")
    public List<Book> getAvailableBooks() {
        return libraryService.getAvailableBooks();
    }

    @PostMapping("/borrow")
    public String borrowBook(@RequestParam Long bookId, @RequestParam Long userId) {
        return libraryService.borrowBook(bookId, userId) ? "Book borrowed successfully" : "Book not available";
    }

    @PostMapping("/return")
    public String returnBook(@RequestParam Long bookId) {
        return libraryService.returnBook(bookId) ? "Book returned successfully" : "Invalid book ID";
    }
}