package com.midterm.SpringCommerce.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.midterm.SpringCommerce.models.Product;


public interface ProductRepository extends JpaRepository<Product, Integer> {
	@Query("SELECT p FROM Product p ORDER BY p.p_id DESC LIMIT 6")
    List<Product> findTop6Products();
	
	List<Product> findByCateId(int CateId);
	
	List<Product> findByBrandId(int BrandId);
	
	@Query("SELECT p FROM Product p WHERE p.p_id != :productId AND p.brandId = (SELECT p2.brandId FROM Product p2 WHERE p2.p_id = :productId)")
	List<Product> findProductRelatedById(@Param("productId") int productId);
}
