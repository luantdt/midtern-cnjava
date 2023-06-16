package com.midterm.SpringCommerce.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.midterm.SpringCommerce.models.Brand;
import com.midterm.SpringCommerce.models.Category;
import com.midterm.SpringCommerce.models.Product;
import com.midterm.SpringCommerce.repositories.BrandRepository;
import com.midterm.SpringCommerce.repositories.CategoryRepository;
import com.midterm.SpringCommerce.repositories.ProductRepository;
import com.midterm.SpringCommerce.services.CardService;
import com.midterm.SpringCommerce.services.CheckAuth;

@Controller
@RequestMapping(path = "/product")
public class ProductController {
	@Autowired
	private ProductRepository repository;

	@Autowired
	private BrandRepository brandRepo;

	@Autowired
	private CategoryRepository categoryRepo;
	
	@Autowired
	private CheckAuth checkAuth;
	
	@Autowired
	private CardService CardService;
	
	@GetMapping("")
	public String allProduct(Model model) {
		List<Product> products = repository.findAll();
		List<Brand> brands = brandRepo.findAll();
		List<Category> categories = categoryRepo.findAll();
		
		checkAuth.isAuth(model);
		CardService.getModel(model);
		model.addAttribute("products", products);
		model.addAttribute("categories", categories);
		model.addAttribute("brands", brands);
		return "products";
	}

	@GetMapping("/{id}")
	public String detailPage(Model model, @PathVariable Integer id) {
		List<Product> products = repository.findProductRelatedById(id);
		List<Brand> brands = brandRepo.findAll();
		List<Category> categories = categoryRepo.findAll();
		Optional<Product> currProduct = repository.findById(id);
		
		checkAuth.isAuth(model);
		CardService.getModel(model);
		
		model.addAttribute("products", products);
		model.addAttribute("categories", categories);
		model.addAttribute("brands", brands);
		model.addAttribute("currProduct", currProduct.get());
		return "detail";
	}
}
