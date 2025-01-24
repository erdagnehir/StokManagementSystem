package com.java.javaProject.Service;

import com.java.javaProject.Repository.*;
import com.java.javaProject.Entity.Order;
import com.java.javaProject.Entity.OrderStatusEnum;
import com.java.javaProject.Entity.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService implements IOrderService {
	@Autowired
	private final OrderRepository orderRepository;

	@Autowired
	private final ProductRepository productRepository;

	public OrderService(OrderRepository orderRepository, ProductRepository productRepository) {
		this.orderRepository = orderRepository;
		this.productRepository = productRepository;
	}

	@Override
	public List<Order> getAllOrders() {
		return orderRepository.findAll();
	}

	@Override
	public Order saveOrder(Order order) {
		order.setOrderStatus(OrderStatusEnum.Bekliyor);
		return orderRepository.save(order);
	}

	@Override
	public void deleteOrder(Long id) {
		orderRepository.deleteById(id);
	}

	@Override
	public Optional<Order> findById(Long id) {
		return orderRepository.findById(id);
	}

	@Override
	public List<Order> findByProductId(Long productId) {
		return orderRepository.findByProductId(productId);
	}

	public void updateOrderStatus(Long orderId, OrderStatusEnum newStatus) {
		Optional<Order> orderOpt = orderRepository.findById(orderId);
		if (orderOpt.isPresent()) {
			Order order = orderOpt.get();
			Product product = productRepository.findById(order.getProduct().getId()).orElse(null);

			if (product == null) {
				throw new IllegalArgumentException("Ürün bulunamadı.");
			}

			if (newStatus == OrderStatusEnum.Onaylandi) {
				int updatedStock = product.getStock() - order.getQuantity();

				if (updatedStock < 0) {
					throw new IllegalArgumentException("Yeterli stok bulunmamaktadır.");
				}

				product.setStock(updatedStock);
			} else if (newStatus == OrderStatusEnum.Iptal) {
				product.setStock(product.getStock() + order.getQuantity());
			}

			productRepository.save(product);
			order.setOrderStatus(newStatus);
			orderRepository.save(order);
		} else {
			throw new IllegalArgumentException("Sipariş " + orderId + " bulunamadı");
		}
	}
	public List<Order> findByOrderStatus(OrderStatusEnum status) {
	    return orderRepository.findByOrderStatus(status);
	}


}