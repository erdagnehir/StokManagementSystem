package com.java.javaProject.Controller;
import com.java.javaProject.Entity.Order;
import com.java.javaProject.Entity.OrderStatusEnum;
import com.java.javaProject.Entity.Product;
import com.java.javaProject.Entity.WareHouse;
import com.java.javaProject.Service.IOrderService;
import com.java.javaProject.Service.IProductService;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/orders")
public class OrderController {
	@Autowired
    private IOrderService orderService;
	@Autowired
	private IProductService productService;
	
    @GetMapping
    public String listOrders(Model model) {
		List<Order> orders = orderService.getAllOrders();
        model.addAttribute("orders", orders);
        return "order/list";
    }

    @GetMapping("/add")
    public String addOrderForm(Model model) {
    	List<Product> products = productService.getAllProducts();
        model.addAttribute("order", new Order());
        model.addAttribute("products", products);
        return "order/add";
    }

    @PostMapping("/add")
    public String addOrder(@ModelAttribute Order order) {
        orderService.saveOrder(order);
        return "redirect:/orders";
    }

    @PostMapping("/delete/{id}")
    public String deleteOrder(@PathVariable Long id) {
        orderService.deleteOrder(id);
        return "redirect:/orders";
    }
    
    @PostMapping("/approve/{id}")
    public String approveOrder(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        try {
            orderService.updateOrderStatus(id, OrderStatusEnum.Onaylandi);
            redirectAttributes.addFlashAttribute("sweetAlertMessage", "Sipariş başarıyla onaylandı!");
            redirectAttributes.addFlashAttribute("sweetAlertType", "success");
        } catch (IllegalArgumentException e) {
            redirectAttributes.addFlashAttribute("sweetAlertMessage", e.getMessage());
            redirectAttributes.addFlashAttribute("sweetAlertType", "error");
        }
        return "redirect:/orders";
    }

    @PostMapping("/reject/{id}")
    public String rejectOrder(@PathVariable Long id) {
    	orderService.updateOrderStatus(id,OrderStatusEnum.Reddedildi);
        return "redirect:/orders";
    }

    @PostMapping("/cancel/{id}")
    public String cancelOrder(@PathVariable Long id) {
    	orderService.updateOrderStatus(id,OrderStatusEnum.Iptal);
        return "redirect:/orders";
    }
    
    @GetMapping("/ordersFilter")
    public String filterOrders(@RequestParam(value = "status", required = false) String status, Model model) {
        List<Order> orders;

        if (status != null && !status.isEmpty()) {
            try {
                
                OrderStatusEnum orderStatus = OrderStatusEnum.valueOf(status);
                orders = orderService.findByOrderStatus(orderStatus);
            } catch (IllegalArgumentException e) {
              
                System.err.println("Invalid status value: " + status);
                orders = Collections.emptyList();
            }
        } else {
            orders = orderService.getAllOrders();
        }

        model.addAttribute("orders", orders);
        return "order/list :: orderTable";
    }



}