package com.midterm.SpringCommerce.models;

import jakarta.annotation.Nullable;
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
@Table(name = "product")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int p_id;

	@Column(length = 255)
	private String name;

	private String description;

	@Column(length = 255)
	@Nullable
	private String image;

	private int price;

	@Column(name = "cate_id")
	private int cateId;

	@Column(name = "brand_id")
	private int brandId;

	public boolean isValid() {
		if (name == null || name.trim().length() == 0) {
			return false;
		}
		if (description == null || description.trim().length() == 0) {
			return false;
		}
		if (image == null || image.trim().length() == 0) {
			return false;
		}
		if (price <= 0) {
			return false;
		}
		if (cateId <= 0) {
			return false;
		}
		if (brandId <= 0) {
			return false;
		}
		return true;
	}
	
	public boolean isValidExceptImg() {
		if (name == null || name.trim().length() == 0) {
			return false;
		}
		if (description == null || description.trim().length() == 0) {
			return false;
		}
		if (price <= 0) {
			return false;
		}
		if (cateId <= 0) {
			return false;
		}
		if (brandId <= 0) {
			return false;
		}
		return true;
	}
}
