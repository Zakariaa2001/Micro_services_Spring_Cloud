package com.example.inventory_service;

import com.example.inventory_service.entities.Product;
import com.example.inventory_service.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.UUID;

@SpringBootApplication
public class InventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(ProductRepository productRepository) {
		return args -> {
			productRepository.save(new Product(UUID.randomUUID().toString(),"Laptop", 1500.00, 10));
			productRepository.save(new Product(UUID.randomUUID().toString(),"Smartphone", 800.00, 20));
			productRepository.save(new Product(UUID.randomUUID().toString(),"Tablet", 500.00, 15));

			productRepository.findAll().forEach(p -> {
				System.out.println("======================");
				System.out.println("ID: " + p.getId());
				System.out.println("Name: " + p.getName());
				System.out.println("Price: " + p.getPrice());
				System.out.println("Quantity: " + p.getQuantity());
				System.out.println("=======================");
			});
		};
	}

}
