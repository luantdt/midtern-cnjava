package com.midterm.SpringCommerce.models;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "order_detail")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetail {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int o_id;
	
	private int shipping_fee;
	private int total_price;
	
	private LocalDateTime delivery_date;
	private String status;
	private int c_id;
	
	@PrePersist
    protected void onCreate() {
		delivery_date = LocalDateTime.now();
		status = "shipping";
		shipping_fee = 20;
    }
}
