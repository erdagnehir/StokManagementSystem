package com.java.javaProject.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.java.javaProject.Entity.*;

public interface OrderRepository extends JpaRepository<Order, Long> {
	List<Order> findByProductId(Long productId);
	
	List<Order> findByOrderStatus(OrderStatusEnum status);
	long count();

}
