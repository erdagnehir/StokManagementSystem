package com.java.javaProject.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "orders")
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "customerName")
	private String customerName;

	@JoinColumn(name = "product_id")
	@ManyToOne
	private Product product;

	@Column(name = "quantity")
	private int quantity;

	@Enumerated(EnumType.ORDINAL)
	@Column(name = "order_status")
	private OrderStatusEnum orderStatus = OrderStatusEnum.Bekliyor;

	public OrderStatusEnum getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(OrderStatusEnum orderStatus) {
		this.orderStatus = orderStatus;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
