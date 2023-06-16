package com.midterm.SpringCommerce.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.midterm.SpringCommerce.models.Card;
import com.midterm.SpringCommerce.models.Customer;
import com.midterm.SpringCommerce.models.Product;
import com.midterm.SpringCommerce.repositories.CardRepository;
import com.midterm.SpringCommerce.repositories.CustomerRepository;
import com.midterm.SpringCommerce.repositories.ProductRepository;

@Service
public class CardService {
	@Autowired
	private CardRepository cardRepo;

	@Autowired
	private CustomerRepository customerRepo;

	@Autowired
	private ProductRepository productRepo;

	@Autowired
	private CheckAuth checkAuth;

	public void getModel(Model model) {
		if (checkAuth.isAuth()) {
			Customer customer = customerRepo.findByUsername(checkAuth.getAuthName());
			List<Card> card = cardRepo.findAllBycId(customer.getC_id());
			List<Product> checkoutDetail = new ArrayList<Product>();
			int total = 0;
			if (card.size() > 0) {
				for (Card c : card) {
					Product pro = productRepo.findById(c.getP_id()).get();
					total += pro.getPrice();
					checkoutDetail.add(pro);
				}
			}
			
			model.addAttribute("checkoutDetail", checkoutDetail);
			model.addAttribute("total", total);
			model.addAttribute("numberItem", card.size());
		} else {
			model.addAttribute("total", 0);
			model.addAttribute("numberItem", 0);
		}
	}

	public void addCard(int id) {
		Customer customer = customerRepo.findByUsername(checkAuth.getAuthName());
		Card newCard = new Card();
		newCard.setP_id(id);
		newCard.setC_id(customer.getC_id());
		newCard.setQuality(1);
		cardRepo.save(newCard);
	}
	
	public void deleteAll() {
		Customer customer = customerRepo.findByUsername(checkAuth.getAuthName());
		cardRepo.deleteAllByCID(customer.getC_id());
	}
}
