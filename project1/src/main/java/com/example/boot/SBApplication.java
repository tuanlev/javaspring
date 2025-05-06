package com.example.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// @SpringBootApplication(
//   scanBasePackages = {"com.example.service", "com.example.web"},
//   exclude = {DataSourceAutoConfiguration.class},
//   excludeName = {"org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration"}
// )
@SpringBootApplication
public class SBApplication {
    public static void main(String[] args) {
        SpringApplication.run(SBApplication.class);
    }
}
