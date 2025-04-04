package com.example.ticketbooking.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.ticketbooking.model.BookingHistory;
import com.example.ticketbooking.model.Movie;
import com.example.ticketbooking.model.NewMovieRequest;
import com.example.ticketbooking.service.MovieService;

@RestController
@RequestMapping("/movie")
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping
    public List<Movie> getMovies(
            @RequestParam(required = false) String title,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date,
            @RequestParam(required = false) String location,
            @RequestParam(required = false) String genre
    ) {
        return movieService.getAllMovies(title, date, location, genre);
    }

    @GetMapping("/{id}")
    public Movie getMovieById(@PathVariable("id") Integer id) {
        return movieService.getMovieById(id);
    }

    @GetMapping("/booking/history")
    public List<BookingHistory> getBookingHistory() {
        return movieService.getBookingHistory();
    }

    @PostMapping
    public void addMovie(@RequestBody NewMovieRequest movie) { // ✅ Fixed Class Reference
        movieService.addMovie(movie);
    }

    @PostMapping("/booking/{movieId}/{quantity}/{totalPrice}")
    public void createBooking(
            @PathVariable("movieId") Integer id,
            @PathVariable("quantity") Integer quantity,
            @PathVariable("totalPrice") Integer totalPrice
    ) {
        movieService.bookTickets(id, quantity, totalPrice);
    }

    @DeleteMapping("/{movieId}")
    public void deleteMovie(@PathVariable("movieId") Integer id) {
        movieService.deleteMovie(id);
    }

    @PutMapping("/{movieId}")
    public void updateMovie(
            @PathVariable("movieId") Integer id, 
            @RequestBody NewMovieRequest movie // ✅ Fixed Class Reference
    ) {
        movieService.updateMovie(id, movie);
    }
}
