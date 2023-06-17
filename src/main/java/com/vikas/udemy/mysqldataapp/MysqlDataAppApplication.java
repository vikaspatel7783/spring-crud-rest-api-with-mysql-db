package com.vikas.udemy.mysqldataapp;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title = "Springboot CRUD REST API backed by MySQL",
				description = "Test poc of Springboot CRUD REST API backed by MySQL",
				version = "v1.0",
				contact = @Contact(
						name = "Vikas Patel",
						email = "vikaspatel7783@gmail.com",
						url = "https://www.linkedin.com/in/vikas-patel-14693ab/"
				),
				license = @License(
						name = "Apache 2.0",
						url = "https://www.linkedin.com/in/vikas-patel-14693ab/"
				)
		)
)
public class MysqlDataAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(MysqlDataAppApplication.class, args);
	}

}
