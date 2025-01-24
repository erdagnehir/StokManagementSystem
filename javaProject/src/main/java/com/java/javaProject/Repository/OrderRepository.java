package com.java.javaProject.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java.javaProject.Entity.*;

public interface OrderRepository extends JpaRepository<Order, Long> {
	List<Order> findByProductId(Long productId);
	
	List<Order> findByOrderStatus(OrderStatusEnum status);

}
