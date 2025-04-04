package com.example.ticketbooking;

import java.time.LocalDate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class TicketBookingSystemApplication {
	public static void main(String[] args) {
		SpringApplication.run(TicketBookingSystemApplication.class, args);
	}

	record NewMovieRequest(
		String description,
		String director,
		String genre,
		String title,
		LocalDate date,
		String location,
		int totalSeats,
		int availableSeats,
		int price
		){}

}