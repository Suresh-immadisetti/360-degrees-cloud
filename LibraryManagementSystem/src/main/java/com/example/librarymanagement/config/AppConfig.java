package com.example.librarymanagement.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.librarymanagement.strategy.BorrowStrategy;
import com.example.librarymanagement.strategy.DefaultBorrowStrategy;

@Configuration
public class AppConfig {

    @Bean
    public BorrowStrategy borrowStrategy() {
        return new DefaultBorrowStrategy();
    }
}
