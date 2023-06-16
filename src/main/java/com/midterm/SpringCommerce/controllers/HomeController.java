package com.midterm.SpringCommerce.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.midterm.SpringCommerce.models.Brand;
import com.midterm.SpringCommerce.models.Category;
import com.midterm.SpringCommerce.models.Product;
import com.midterm.SpringCommerce.repositories.BrandRepository;
import com.midterm.SpringCommerce.repositories.CategoryRepository;
import com.midterm.SpringCommerce.repositories.ProductRepository;
import com.midterm.SpringCommerce.services.CardService;
import com.midterm.SpringCommerce.services.CheckAuth;

@Controller
public class HomeController {
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private BrandRepository brandRepo;

	@Autowired
	private CategoryRepository categoryRepo;
	
	@Autowired
	private CheckAuth checkAuth;
	
	@Autowired
	private CardService CardService;
	
	@GetMapping("/")
	public String home(Model model) {
		List<Product> products = productRepository.findTop6Products();
		List<Brand> brands = brandRepo.findAll();
		List<Category> categories = categoryRepo.findAll();
		checkAuth.isAuth(model);
		CardService.getModel(model);
		
		model.addAttribute("products", products);
		model.addAttribute("categories", categories);
		model.addAttribute("brands", brands);
		return "index";
	}
	
	@GetMapping("/access-denied")
	public String accessDenied() {
		return "access-denied";
	}
}
