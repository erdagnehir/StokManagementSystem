package com.java.javaProject.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.java.javaProject.Entity.Order;
import com.java.javaProject.Entity.OrderStatusEnum;

public interface IOrderService {
	List<Order> getAllOrders();

	Order saveOrder(Order product);

	void deleteOrder(Long id);

	Optional<Order> findById(Long id);

	List<Order> findByProductId(Long productId);

	void updateOrderStatus(Long orderId, OrderStatusEnum newStatus);
	List<Order> findByOrderStatus(OrderStatusEnum status);
	List<Long> findMostOrderedProductsThisWeek(LocalDate startDate);
}