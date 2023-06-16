package com.midterm.SpringCommerce.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.midterm.SpringCommerce.models.OrderDetail;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, Integer>{
	@Query("SELECT o FROM OrderDetail o WHERE o.c_id = :CID")
	List<OrderDetail> findAllBycId(@Param("CID")int CID);
}
