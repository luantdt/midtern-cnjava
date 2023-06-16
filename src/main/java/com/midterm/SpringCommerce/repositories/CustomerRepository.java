package com.midterm.SpringCommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.midterm.SpringCommerce.models.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{
	Customer findByUsername(String username);
}
