package com.example.librarymanagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import com.example.librarymanagement.factory.BookFactory;
import com.example.librarymanagement.model.Book;
import com.example.librarymanagement.model.User;
import com.example.librarymanagement.repository.BookRepository;
import com.example.librarymanagement.repository.UserRepository;

@Service
public class LibraryService {
    private final BookRepository bookRepository;
    private final UserRepository userRepository;

    public LibraryService(BookRepository bookRepository, UserRepository userRepository) {
        this.bookRepository = bookRepository;
        this.userRepository = userRepository;
    }

    // ✅ Use BookFactory to create books
    public Book addBook(String title, String author) {
        Book book = BookFactory.createBook(title, author);
        return bookRepository.save(book);
    }

    // ✅ Register a new user
    public User registerUser(String name) {
        return userRepository.save(new User(name));
    }

    // ✅ Get all available books
    public List<Book> getAvailableBooks() {
        return bookRepository.findAll().stream().filter(Book::isAvailable).toList();
    }

    // ✅ Borrow a book and associate it with a user
    public boolean borrowBook(Long bookId, Long userId) {
        Optional<Book> bookOpt = bookRepository.findById(bookId);
        Optional<User> userOpt = userRepository.findById(userId);

        if (bookOpt.isPresent() && userOpt.isPresent() && bookOpt.get().isAvailable()) {
            Book book = bookOpt.get();
            book.setAvailable(false);
            book.setBorrowedBy(userOpt.get()); // ✅ Assign the book to the user
            bookRepository.save(book);
            return true;
        }
        return false;
    }

    // ✅ Return a book
    public boolean returnBook(Long bookId) {
        Optional<Book> bookOpt = bookRepository.findById(bookId);
        if (bookOpt.isPresent()) {
            Book book = bookOpt.get();
            book.setAvailable(true);
            book.setBorrowedBy(null); // ✅ Remove the borrowed user
            bookRepository.save(book);
            return true;
        }
        return false;
    }
}
