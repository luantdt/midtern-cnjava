package com.midterm.SpringCommerce.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.midterm.SpringCommerce.models.OrderUnit;

public interface OrderUnitRepository extends JpaRepository<OrderUnit, Integer>{
	@Query("SELECT ou FROM OrderUnit ou WHERE ou.o_id = :OID")
	List<OrderUnit> findAllByoid(@Param("OID")int OID);
}
