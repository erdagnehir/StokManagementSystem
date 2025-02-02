package com.java.javaProject.Service;

import com.java.javaProject.Entity.Product;
import java.util.List;
import java.util.Optional;

public interface IProductService {
	List<Product> getAllProducts();

	Product saveProduct(Product product);

	String deleteProduct(Long id);

	Optional<Product> findById(Long id);
	List<Product> getSortedProducts(String order);
	List<Product> getLatestProducts();
}