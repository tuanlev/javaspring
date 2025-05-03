
package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;



@RestController
@SpringBootApplication
public class Project1Application {

	@RequestMapping("/")
	public String home() {
		return "Hello World!1";
	}
	@RequestMapping("/hello")
	public String hello() {
		return "Hello from Spring Boot!";
	}

	public static void main(String[] args) {
		SpringApplication.run(Project1Application.class, args);
	}

}