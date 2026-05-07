package com.inventory.inventory_system.dto;

import java.time.LocalDateTime;

import com.inventory.inventory_system.entity.enums.OrderStatus;


public class OrderDto {

	private Long id;
	private Long productId;
	private Integer quantity;
	private String status;
	private LocalDateTime createdAt;
	private OrderStatus orderStatus;
	private Long categoryId;
	
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getProductId() {
		return productId;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
	
	
	public OrderStatus getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}
	
	
	public Long getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}
	public OrderDto(Long id, Long productId, Integer quantity, String status, LocalDateTime createdAt,
			OrderStatus orderStatus,Long categoryId) { 
		super();
		this.id = id;
		this.productId = productId;
		this.quantity = quantity;
		this.status = status;
		this.createdAt = createdAt;
		this.orderStatus = orderStatus;
		this.categoryId=categoryId;  
		
	}
	public OrderDto() {
		super();
		// TODO Auto-generated constructor stub 
	}
	@Override
	public String toString() { 
		return "OrderDto [id=" + id + ", productId=" + productId + ", quantity=" + quantity + ", status=" + status
				+ ", createdAt=" + createdAt + ", orderStatus=" + orderStatus + "]";
	}
	
}
