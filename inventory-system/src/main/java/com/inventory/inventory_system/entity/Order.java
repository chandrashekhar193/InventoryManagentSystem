package com.inventory.inventory_system.entity;

import java.time.LocalDateTime;

import com.inventory.inventory_system.entity.enums.OrderStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "`order`")
public class Order {
	
		@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    private Long productId;
	    private Integer quantity;
	    private String status;
	    private Long categoryId;
	    
	    @Enumerated(EnumType.STRING)
	    private OrderStatus orderStatus;

	    private LocalDateTime createdAt;

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

		public Order(Long id, Long productId, Integer quantity, String status, OrderStatus orderStatus,
				LocalDateTime createdAt,Long categoryId) {
			super();
			this.id = id;
			this.productId = productId;
			this.quantity = quantity;
			this.status = status;
			this.orderStatus = orderStatus;
			this.createdAt = createdAt;
			this.categoryId=categoryId;
		}

		public Order() {
			super();
			// TODO Auto-generated constructor stub
		}

		@Override
		public String toString() {
			return "Order [id=" + id + ", productId=" + productId + ", quantity=" + quantity + ", status=" + status
					+ ", orderStatus=" + orderStatus + ", createdAt=" + createdAt + "]";
		}

	
	    
	    
	    
	    

}
