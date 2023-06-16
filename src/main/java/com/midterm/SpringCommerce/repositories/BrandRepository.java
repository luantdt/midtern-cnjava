package com.midterm.SpringCommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.midterm.SpringCommerce.models.Brand;

public interface BrandRepository extends JpaRepository<Brand, Integer>{
	
}
