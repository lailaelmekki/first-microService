package org.elmekki.custmorservice;

import org.elmekki.custmorservice.config.GlobalConfig;
import org.elmekki.custmorservice.entities.Customer;
import org.elmekki.custmorservice.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
@EnableConfigurationProperties(GlobalConfig.class)
public class CustmorServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustmorServiceApplication.class, args);
	}
	@Bean
	CommandLineRunner commandLineRunner(CustomerRepository customerRepository){
		return args -> {
			List<Customer> customerList =List.of (
					 Customer.builder()
							.firstName("John")
							.lastName("Doe")
							.email("john.doe@example.com")
							 .build(),
					 Customer.builder()
							 .firstName("laila")
					         .lastName("elmekki")
					         .email("elmekki@example.com")
							 .build()
			);
			customerRepository.saveAll(customerList);



		};
	}

}
