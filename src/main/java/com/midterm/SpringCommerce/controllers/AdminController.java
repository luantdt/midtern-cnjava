package com.midterm.SpringCommerce.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.midterm.SpringCommerce.models.Brand;
import com.midterm.SpringCommerce.models.Category;
import com.midterm.SpringCommerce.models.Customer;
import com.midterm.SpringCommerce.models.LoginRequest;
import com.midterm.SpringCommerce.models.Product;
import com.midterm.SpringCommerce.repositories.BrandRepository;
import com.midterm.SpringCommerce.repositories.CategoryRepository;
import com.midterm.SpringCommerce.repositories.CustomerRepository;
import com.midterm.SpringCommerce.repositories.ProductRepository;
import com.midterm.SpringCommerce.services.IStorageService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")
@PreAuthorize("hasRole('ADMIN')")
public class AdminController {

	@Autowired
	private CustomerRepository customerRepo;
	
	@Autowired
	private ProductRepository repository;

	@Autowired
	private BrandRepository brandRepo;

	@Autowired
	private CategoryRepository categoryRepo;

	@Autowired
	private IStorageService storageService;

	@GetMapping("")
	public String getAdminHomePage(Model model, @ModelAttribute("successMessage") String successMessage,
			@ModelAttribute("currPro") Product currPro, @ModelAttribute("currBrand") Brand currBrand,
			@ModelAttribute("currCate") Category currCate) {
		List<Product> products = repository.findAll();
		List<Brand> brands = brandRepo.findAll();
		List<Category> categories = categoryRepo.findAll();

		model.addAttribute("products", products);
		model.addAttribute("categories", categories);
		model.addAttribute("brands", brands);
		model.addAttribute("successMessage", successMessage);
		model.addAttribute("currPro", currPro);
		model.addAttribute("currBrand", currBrand);
		model.addAttribute("currCate", currCate);

		return "admin/index";
	}

	@GetMapping("/login")
	public String getAdminLoginPage() {
		return "admin/login";
	}

	@PostMapping("/login")
	public String postAdminLoginPage(@ModelAttribute("loginRequest") LoginRequest loginRequest, Model model,
			HttpSession session) {
		if (loginRequest.getUsername() == null || loginRequest.getUsername() == "" || loginRequest.getPassword() == null
				|| loginRequest.getPassword() == "") {
			model.addAttribute("msg", "username or password is empty");
			return "admin/login";
		}
		Customer cus = customerRepo.findByUsername(loginRequest.getUsername());
		if (cus.getPassword().equals(loginRequest.getPassword())) {
			session.setAttribute("adminName", cus.getName());
			return "redirect:/admin";
		} else {
			model.addAttribute("msg", "wrong username or password");
			return "admin/login";
		}
	}

	@GetMapping({ "/{id}" })
	public String findBy(@PathVariable Integer id, RedirectAttributes redirectAttributes) {
		Product currPro = repository.findById(id).get();
		Brand currBrand = brandRepo.findById(currPro.getBrandId()).get();
		Category currCate = categoryRepo.findById(currPro.getCateId()).get();

		redirectAttributes.addFlashAttribute("currPro", currPro);
		redirectAttributes.addFlashAttribute("currBrand", currBrand);
		redirectAttributes.addFlashAttribute("currCate", currCate);
		return "redirect:/admin";
	}

	@PostMapping({ "/{id}" })
	public String findBy(@ModelAttribute Product newProduct, @PathVariable Integer id,
			RedirectAttributes redirectAttributes) {

		if (newProduct.isValid()) {
			repository.findById(id).map(product -> {
				product.setName(newProduct.getName());
				product.setPrice(newProduct.getPrice());
				product.setDescription(newProduct.getDescription());
				product.setImage(newProduct.getImage());
				product.setCateId(newProduct.getCateId());
				product.setBrandId(newProduct.getBrandId());
				redirectAttributes.addFlashAttribute("successMessage", "Update product has successful");
				return repository.save(product);
			}).orElseGet(() -> {
				redirectAttributes.addFlashAttribute("errorMessage", "Update product has unsuccessful");
				return null;
			});
		} else {
			redirectAttributes.addFlashAttribute("errorMessage",
					"Could not update product. Make sure you have entered all the fields. Please select the product again to update information");
		}

		return "redirect:/admin";
	}

	@GetMapping("/delete/{id}")
	public String deleteProduct(@PathVariable int id, RedirectAttributes redirectAttributes) {
		boolean exists = repository.existsById(id);
		if (exists) {
			repository.deleteById(id);
			redirectAttributes.addFlashAttribute("successMessage", "Delete product has successful!");
		} else {
			redirectAttributes.addFlashAttribute("errorMessage", "Could not found product!");
		}
		return "redirect:/admin";
	}

	@PostMapping("/add")
	public String uploadFile(@RequestParam("file") MultipartFile file, @ModelAttribute Product newProduct,
			RedirectAttributes redirectAttributes) {

		if (newProduct.isValidExceptImg()) {
			try {
				String generatedFileName = storageService.storeFile(file);
				newProduct.setImage(generatedFileName);
				repository.save(newProduct);
				redirectAttributes.addFlashAttribute("successMessage", "Add new product has successful");
				return "redirect:/admin";
			} catch (Exception exception) {
				redirectAttributes.addFlashAttribute("errorMessage", exception.getMessage());
				return "redirect:/admin";
			}
		} else {
			redirectAttributes.addFlashAttribute("errorMessage",
					"Could not add new product. Make sure you have entered all the fields. Please select the product again to update information");
			return "redirect:/admin";
		}

	}
}
