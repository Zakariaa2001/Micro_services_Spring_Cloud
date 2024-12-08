package com.example.billing_service;

import com.example.billing_service.entities.Bill;
import com.example.billing_service.entities.ProductItem;
import com.example.billing_service.feign.CustomerRestClient;
import com.example.billing_service.feign.ProductRestClient;
import com.example.billing_service.model.Customer;
import com.example.billing_service.model.Product;
import com.example.billing_service.repository.BillRepository;
import com.example.billing_service.repository.ProductItemRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Random;

@SpringBootApplication
@EnableFeignClients
public class BillingServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BillingServiceApplication.class, args);
	}
	@Bean
	CommandLineRunner commandLineRunner(BillRepository billRepository,
										ProductItemRepository productItemRepository,
										CustomerRestClient customerRestClient,
										ProductRestClient productRestClient) {

		return args -> {
			Collection<Customer> customers = customerRestClient.getAllCustomers().getContent();
			Collection<Product> products = productRestClient.getAllProducts().getContent();

			customers.forEach(customer -> {
				// Création d'une facture (Bill) avec un constructeur classique
				Bill bill = new Bill();
				bill.setBillingDate(new Date());
				bill.setCustomerId(customer.getId());
				billRepository.save(bill);

				// Création des items produits (ProductItem) avec un constructeur classique
				products.forEach(product -> {
					ProductItem productItem = new ProductItem();
					productItem.setBill(bill);
					productItem.setProductId(product.getId());
					productItem.setQuantity(1 + new Random().nextInt(10));
					productItem.setUnitPrice(product.getPrice());
					productItemRepository.save(productItem);
				});
			});
		};
	}



}
