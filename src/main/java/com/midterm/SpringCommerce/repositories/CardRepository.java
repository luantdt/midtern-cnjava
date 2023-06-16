package com.midterm.SpringCommerce.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.midterm.SpringCommerce.models.Card;

public interface CardRepository extends JpaRepository<Card, Integer> {
	@Query("SELECT c FROM Card c WHERE c.c_id = :CID")
	List<Card> findAllBycId(@Param("CID")int CID);
	
	@Modifying
	@Transactional
	@Query("DELETE FROM Card c WHERE c.c_id = :CID")
	void deleteAllByCID(@Param("CID") int CID);
}
