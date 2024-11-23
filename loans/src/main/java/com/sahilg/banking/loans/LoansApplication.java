package com.sahilg.banking.loans;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title = "Loans microservice",
				description = "Loans microservice REST API Documentation",
				contact = @Contact(
						name = "Sahil Ghadage",
						url = "https://www.linkedin.com/in/sahilghadage"
				)

		)

)
public class LoansApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoansApplication.class, args);
	}

}
