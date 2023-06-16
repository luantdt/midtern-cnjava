package com.midterm.SpringCommerce.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "order_unit")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class OrderUnit {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int ou_id;
	
	private int p_id;
	private int o_id;
	private int unit_price;
	private int quatity;

}
