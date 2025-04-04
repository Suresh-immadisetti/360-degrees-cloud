package com.example.ticketbooking.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ticketbooking.model.Movie;

public interface MovieRepository extends JpaRepository<Movie, Integer> {
}