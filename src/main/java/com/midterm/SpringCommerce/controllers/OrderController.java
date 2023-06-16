package com.midterm.SpringCommerce.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.midterm.SpringCommerce.services.OrderService;

@Controller
@RequestMapping("/order")
@PreAuthorize("hasRole('MEMBER') || hasRole('ADMIN')")
public class OrderController {
	@Autowired
	private OrderService oderService;
	
	@GetMapping("")
	public String showOrder(Model model) {
		oderService.getAllAndModel(model);
		
		return "order";
	}
}
