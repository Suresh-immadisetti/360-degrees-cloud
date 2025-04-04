package com.example.productmanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication(scanBasePackages = "com.example.productmanagement")
@EntityScan("com.example.productmanagement.entity") // Add this line
public class ProductManagementApplication {
	public static void main(String[] args) {
		SpringApplication.run(ProductManagementApplication.class, args);
	}
}
