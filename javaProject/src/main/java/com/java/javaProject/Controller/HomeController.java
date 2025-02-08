package com.java.javaProject.Controller;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.java.javaProject.Entity.Product;
import com.java.javaProject.Repository.OrderRepository;
import com.java.javaProject.Repository.ProductRepository;
import com.java.javaProject.Repository.WareHouseRepository;
import com.java.javaProject.Service.OrderService;

import org.springframework.ui.Model;

@Controller
public class HomeController {
	private OrderService orderService;
	private final WareHouseRepository warehouseRepository;
	private final OrderRepository orderRepository;
	private final ProductRepository productRepository;

	public HomeController(WareHouseRepository warehouseRepository, OrderRepository orderRepository,
			ProductRepository productRepository, OrderService orderService) {
		this.warehouseRepository = warehouseRepository;
		this.orderRepository = orderRepository;
		this.productRepository = productRepository;
		this.orderService = orderService;
	}

	@GetMapping("/")
	public String home(Model model) {
		long totalWarehouses = warehouseRepository.count();
		long totalOrders = orderRepository.count();
		Long totalStock = productRepository.getTotalStock();

		if (totalStock == null) {
			totalStock = 0L;
		}

		LocalDate startDate = LocalDate.now().minusDays(7);

		List<Long> mostOrderedProductId = orderService.findMostOrderedProductsThisWeek(startDate);

		List<Product> featuredProducts = null;
		if (!mostOrderedProductId.isEmpty()) {
			featuredProducts = mostOrderedProductId.stream().map(productRepository::findById)
					.filter(Optional::isPresent).map(Optional::get).toList();
		}

		model.addAttribute("featuredProducts", featuredProducts);
		model.addAttribute("totalWarehouses", totalWarehouses);
		model.addAttribute("totalOrders", totalOrders);
		model.addAttribute("totalStock", totalStock);

		return "home/index";
	}

}
