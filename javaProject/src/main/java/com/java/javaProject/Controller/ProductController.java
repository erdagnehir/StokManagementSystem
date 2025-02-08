package com.java.javaProject.Controller;

import com.java.javaProject.Entity.Product;
import com.java.javaProject.Entity.WareHouse;
import com.java.javaProject.Service.IProductService;
import com.java.javaProject.Service.IWareHouseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {
	@Autowired
	private IProductService productService;

	@Autowired
	private IWareHouseService warehouseService;

	@GetMapping
	public String listProducts(Model model) {
		List<Product> products = productService.getAllProducts();
		model.addAttribute("products", products);
		return "product/list";
	}

	@PostMapping("/delete/{id}")
	public String deleteProduct(@PathVariable Long id, Model model) {
		String result = productService.deleteProduct(id);
		if (result != null) {
			List<Product> products = productService.getAllProducts();
			model.addAttribute("products", products);
			model.addAttribute("errorMessage", result);
			return "product/list";
		}

		return "redirect:/products";
	}

	@GetMapping("/add")
	public String addProductFormWithoutId(Model model) {
		List<WareHouse> warehouses = warehouseService.getAllWarehouses();
		model.addAttribute("product", new Product());
		model.addAttribute("warehouses", warehouses);
		return "product/add";
	}

	@GetMapping("/add/{id}")
	public String addProductFormWithId(@PathVariable Long id, Model model) {
		List<WareHouse> warehouses = warehouseService.getAllWarehouses();
		Product product = productService.findById(id).orElse(null);
		model.addAttribute("product", product);
		model.addAttribute("warehouses", warehouses);
		return "product/add";
	}

	@PostMapping("/add")
	public String saveProduct(@ModelAttribute Product product) {
		productService.saveProduct(product);
		return "redirect:/products";
	}

	@GetMapping("/sort")
	@ResponseBody
	public List<Product> sortProducts(@RequestParam String order) {
		return productService.getSortedProducts(order);
	}
}
