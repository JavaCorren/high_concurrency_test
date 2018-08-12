package com.example.high_currency_test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication(scanBasePackages = "com.example")
public class HighCurrencyTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(HighCurrencyTestApplication.class, args);
	}
}
