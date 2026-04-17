package com.inventory.inventory_system.serviceImpl;

import java.time.LocalDateTime;


import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;


import com.inventory.inventory_system.dto.Response;
import com.inventory.inventory_system.entity.Order;
import com.inventory.inventory_system.entity.Product;
import com.inventory.inventory_system.entity.enums.OrderStatus;
import com.inventory.inventory_system.exception.ValidationException;
import com.inventory.inventory_system.mapper.OrderMapper;
import com.inventory.inventory_system.repositoy.OrderRepo;
import com.inventory.inventory_system.repositoy.ProductRepo;
import com.inventory.inventory_system.service.OrderService;

import jakarta.transaction.Transactional;

@Service
public class OrderServiceImpl implements OrderService {

	private final OrderRepo orderRepo;
	private final ProductRepo productRepo;

	public OrderServiceImpl(OrderRepo orderRepo, ProductRepo productRepo) {
		this.orderRepo = orderRepo;
		this.productRepo = productRepo;
	}

	@Override
	@Transactional
	public Response placeOrder(Long productId, Integer quantity) {

		if (productId == null || productId <= 0) {
			return new Response(HttpStatus.BAD_REQUEST.value(), "Invalid product id");
		}

		if (quantity == null || quantity <= 0) {
			return new Response(HttpStatus.BAD_REQUEST.value(), "Quantity must be greater than 0");
		}

		Product product = productRepo.findById(productId)
				.orElseThrow(() -> new ValidationException(HttpStatus.BAD_REQUEST.value(),
						"Product not found with id: " + productId));

		LocalDateTime now = LocalDateTime.now();

		if (product.getAvailableQuantity() < quantity) {

			Order failedOrder = new Order();
			failedOrder.setProductId(productId);
			failedOrder.setQuantity(quantity);
			failedOrder.setStatus("FAILED");
			failedOrder.setCreatedAt(now);

			orderRepo.save(failedOrder);

			return new Response(HttpStatus.BAD_REQUEST.value(), "Insufficient stock available",
					OrderMapper.toDTO(failedOrder));
		}

		product.setAvailableQuantity(product.getAvailableQuantity() - quantity);
		product.setReservedQuantity(product.getReservedQuantity() + quantity);
		productRepo.save(product);

		Order order = new Order();
		order.setProductId(productId);
		order.setQuantity(quantity);
		order.setStatus("CREATED");
		order.setCreatedAt(now);

		Order savedOrder = orderRepo.save(order);

		return new Response(HttpStatus.OK.value(), "Order placed successfully", OrderMapper.toDTO(savedOrder));
	}

	@Override
	@Transactional
	public Response cancelOrder(Long orderId) {

		if (orderId == null || orderId <= 0) {
			return new Response(HttpStatus.BAD_REQUEST.value(), "Invalid order id");
		}

		Order order = orderRepo.findById(orderId).orElseThrow(
				() -> new ValidationException(HttpStatus.BAD_REQUEST.value(), "Order not found with id: " + orderId));

		if (order.getOrderStatus() != OrderStatus.CREATED) {
			return new Response(HttpStatus.BAD_REQUEST.value(), "Only CREATED orders can be cancelled");
		}

		Product product = productRepo.findById(order.getProductId())
				.orElseThrow(() -> new ValidationException(HttpStatus.BAD_REQUEST.value(),
						"Product not found with id: " + order.getProductId()));

		product.setAvailableQuantity(product.getAvailableQuantity() + order.getQuantity());
		product.setReservedQuantity(product.getReservedQuantity() - order.getQuantity());
		productRepo.save(product);

		order.setOrderStatus(OrderStatus.CANCELLED);
		Order updatedOrder = orderRepo.save(order);

		return new Response(HttpStatus.OK.value(), "Order cancelled successfully", OrderMapper.toDTO(updatedOrder));
	}

	@Override
	@Transactional
	public Response completeOrder(Long orderId) {

		if (orderId == null || orderId <= 0) {
			return new Response(HttpStatus.BAD_REQUEST.value(), "Invalid order id");
		}

		Order order = orderRepo.findById(orderId).orElseThrow(
				() -> new ValidationException(HttpStatus.BAD_REQUEST.value(), "Order not found with id: " + orderId));

		if (order.getOrderStatus() != OrderStatus.CREATED) {
			return new Response(HttpStatus.BAD_REQUEST.value(), "Only CREATED orders can be completed");
		}

		Product product = productRepo.findById(order.getProductId())
				.orElseThrow(() -> new ValidationException(HttpStatus.BAD_REQUEST.value(),
						"Product not found with id: " + order.getProductId()));

		product.setReservedQuantity(product.getReservedQuantity() - order.getQuantity());
		productRepo.save(product);

		order.setOrderStatus(OrderStatus.COMPLETED); 
		Order updatedOrder = orderRepo.save(order);

		return new Response(HttpStatus.OK.value(), "Order completed successfully", OrderMapper.toDTO(updatedOrder));
	}
}
