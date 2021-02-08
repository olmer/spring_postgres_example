package com.olmer.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@SpringBootApplication
@RestController
public class SpringdemoApplication {

	@Autowired
	private CustomerRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(SpringdemoApplication.class, args);
	}

	@RequestMapping("/")
	public String home() {
		List allCustomers = this.repository.findAll();
//		logger.info("Number of customers: " + allCustomers.size());

		Customer newCustomer = new Customer();
//		newCustomer.setFirstName("John");
//		newCustomer.setLastName("Doe");
//		logger.info("Saving new customer...");
		this.repository.save(newCustomer);

		allCustomers = this.repository.findAll();
//		logger.info("Number of customers: " + allCustomers.size());
		return "Hello Docker World 2: " + allCustomers.size();
	}
}
