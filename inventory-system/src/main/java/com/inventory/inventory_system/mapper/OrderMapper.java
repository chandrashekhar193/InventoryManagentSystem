package com.inventory.inventory_system.mapper;

import java.time.LocalDateTime;

import com.inventory.inventory_system.dto.OrderDto;
import com.inventory.inventory_system.entity.Order;

public class OrderMapper {

	// DTO → Entity
	public static Order toEntity(OrderDto dto) {

		if (dto == null)
			return null;

		Order order = new Order();

		order.setProductId(dto.getProductId());
		order.setQuantity(dto.getQuantity());

		// business defaults
		order.setStatus("CREATED");
		order.setCreatedAt(LocalDateTime.now());
		order.setOrderStatus(dto.getOrderStatus());

		return order;
	}

	// Entity → DTO
	public static OrderDto toDTO(Order order) {

		if (order == null)
			return null;

		OrderDto dto = new OrderDto(); 

		dto.setId(order.getId());
		dto.setProductId(order.getProductId());
		dto.setQuantity(order.getQuantity());
		dto.setStatus(order.getStatus());
		dto.setCreatedAt(order.getCreatedAt());
		dto.setOrderStatus(order.getOrderStatus());

		return dto;
	}
}
