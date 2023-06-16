package com.midterm.SpringCommerce.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.midterm.SpringCommerce.models.Card;
import com.midterm.SpringCommerce.models.Customer;
import com.midterm.SpringCommerce.models.OrderDetail;
import com.midterm.SpringCommerce.models.OrderUnit;
import com.midterm.SpringCommerce.models.Product;
import com.midterm.SpringCommerce.repositories.CardRepository;
import com.midterm.SpringCommerce.repositories.CustomerRepository;
import com.midterm.SpringCommerce.repositories.OrderDetailRepository;
import com.midterm.SpringCommerce.repositories.OrderUnitRepository;
import com.midterm.SpringCommerce.repositories.ProductRepository;

@Service
public class OrderService {
	@Autowired
	private CardRepository cardRepo;

	@Autowired
	private CustomerRepository customerRepo;

	@Autowired
	private ProductRepository productRepo;

	@Autowired
	private CheckAuth checkAuth;

	@Autowired
	private OrderDetailRepository OrderDetailRepo;

	@Autowired
	private OrderUnitRepository OrderUnitRepo;

	public void payAllItem() {
		if (checkAuth.isAuth()) {
			OrderDetail orderDetail = new OrderDetail();
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

			orderDetail.setTotal_price(total);
			orderDetail.setC_id(customer.getC_id());
			OrderDetailRepo.save(orderDetail);
			OrderDetailRepo.flush();
			for (Product product : checkoutDetail) {
				OrderUnit orderUnit = new OrderUnit();
				orderUnit.setP_id(product.getP_id());
				orderUnit.setO_id(orderDetail.getO_id());
				orderUnit.setUnit_price(product.getPrice());
				orderUnit.setQuatity(1);
				OrderUnitRepo.save(orderUnit);
			}

			cardRepo.deleteAllByCID(customer.getC_id());
		}
	}

	public void getAllAndModel(Model model) {
		Customer customer = customerRepo.findByUsername(checkAuth.getAuthName());
		List<OrderDetail> orderDetail = OrderDetailRepo.findAllBycId(customer.getC_id());
		List<OrderUnit> orderUnit = new ArrayList<OrderUnit>();
		List<String> proName = new ArrayList<String>();
		for (OrderDetail orderDetail2 : orderDetail) {
			List<OrderUnit> unit = OrderUnitRepo.findAllByoid(orderDetail2.getO_id());
			orderUnit.addAll(unit);
			for (OrderUnit u : unit) {
				String name = productRepo.findById(u.getP_id()).get().getName();
				proName.add(name);
			}
		}
		model.addAttribute("proName", proName);
		model.addAttribute("orderDetail", orderDetail);
		model.addAttribute("orderUnit", orderUnit);
	}
}
