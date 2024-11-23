package com.sahilg.banking.cards;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title = "Cards microservice",
				description = "Cards microservice REST API Documentation",
				version = "v1",
				contact = @Contact(
						name = "Sahil Ghadage",
						url = "https://www.linkedin.com/in/sahilghadage"
				)

		)
)
public class CardsApplication {

	public static void main(String[] args) {
		SpringApplication.run(CardsApplication.class, args);
	}

}
