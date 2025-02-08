package com.java.javaProject.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.java.javaProject.Entity.*;

public interface ProductRepository extends JpaRepository<Product, Long> {
	public List<Product> findByWareHouse_Id(Long warehouseId);

	@Query("SELECT p FROM Product p " + "JOIN Order o ON p.id = o.product.id " + "GROUP BY p.id "
			+ "ORDER BY SUM(o.quantity) DESC")
	List<Product> findBestSellingProducts();

	List<Product> findTopByOrderByIdDesc();

	@Query("SELECT SUM(p.stock) FROM Product p")
	Long getTotalStock();
}