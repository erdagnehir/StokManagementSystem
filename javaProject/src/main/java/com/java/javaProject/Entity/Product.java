package com.java.javaProject.Entity;
import jakarta.persistence.*;
@Entity
@Table(name = "products")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	 private String name;
	 private String description;
	 
	 @Column(nullable = false)
	 private Double price;
	 
	 @Column(nullable = false)	
	 private Integer stock;
	 
	 @ManyToOne
	 @JoinColumn(name = "warehouse_id", nullable = false )
	 private WareHouse wareHouse;
		
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public WareHouse getWarehouse() {
		return wareHouse;
	}
	public void setWarehouse(WareHouse warehouse) {
		this.wareHouse = warehouse;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Integer getStock() {
		return stock;
	}
	public void setStock(Integer stock) {
		this.stock = stock;
	}
	 
}
