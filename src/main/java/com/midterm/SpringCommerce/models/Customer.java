package com.midterm.SpringCommerce.models;

import jakarta.persistence.Column;
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
@Table(name = "customer")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int c_id;
	
	@Column(length=255, unique = true)
	private String username;
	
	@Column(length=255)
	private String password;
	
	@Column(length=255)
	private String email;
	
	@Column(length=255)
	private String name;
	
	@Column(length=10)
	private String phone;
	
	@Column(length=255)
	private String address;
}
