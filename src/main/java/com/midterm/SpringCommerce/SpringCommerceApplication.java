package com.midterm.SpringCommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.midterm.SpringCommerce.models.LoginRequest;

@SpringBootApplication
public class SpringCommerceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCommerceApplication.class, args);
	}
	
	@Bean(name="USER_ADMIN_BEAN")
	public LoginRequest createAdmin() {
		return new LoginRequest("admin", "admin123");
	}
	
}
