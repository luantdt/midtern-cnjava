package com.midterm.SpringCommerce.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.midterm.SpringCommerce.models.Brand;
import com.midterm.SpringCommerce.models.Category;
import com.midterm.SpringCommerce.repositories.BrandRepository;
import com.midterm.SpringCommerce.repositories.CategoryRepository;
import com.midterm.SpringCommerce.services.CardService;
import com.midterm.SpringCommerce.services.CheckAuth;
import com.midterm.SpringCommerce.services.OrderService;

@Controller
@RequestMapping("/card")
@PreAuthorize("hasRole('MEMBER') || hasRole('ADMIN')")
public class CardController {
	@Autowired
	private CardService cardService;

	@Autowired
	private BrandRepository brandRepo;

	@Autowired
	private CategoryRepository categoryRepo;

	@Autowired
	private CheckAuth checkAuth;

	@Autowired
	private OrderService orderService;

	@GetMapping("/checkout")
	public String getCheckOut(Model model) {
		List<Brand> brands = brandRepo.findAll();
		List<Category> categories = categoryRepo.findAll();
		checkAuth.isAuth(model);

		cardService.getModel(model);
		model.addAttribute("categories", categories);
		model.addAttribute("brands", brands);
		return "checkout";
	}

	@GetMapping("/pay")
	public String pay() {
		orderService.payAllItem();
		return "redirect:/";
	}

	@GetMapping("/{id}")
	public String addCard(@PathVariable Integer id) {
		cardService.addCard(id);
		return "redirect:/";
	}

}
