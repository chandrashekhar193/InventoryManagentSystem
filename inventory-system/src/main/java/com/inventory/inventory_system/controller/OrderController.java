package com.inventory.inventory_system.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inventory.inventory_system.dto.OrderRequest;
import com.inventory.inventory_system.dto.Response;
import com.inventory.inventory_system.service.OrderService;

@RestController
@RequestMapping("/api/order")
public class OrderController {

	private final OrderService orderService;

	public OrderController(OrderService orderService) {
		this.orderService = orderService;
	}

	@PostMapping("/saveOrder")
	public ResponseEntity<Response> placeOrder(@RequestBody OrderRequest request) {

		Response response = orderService.placeOrder(request.getProductId(), request.getQuantity());

		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}

	@PostMapping("/{orderId}/cancel")
	public ResponseEntity<Response> cancelOrder(@PathVariable Long orderId) {

		Response response = orderService.cancelOrder(orderId);

		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@PostMapping("/{orderId}/complete")
	public ResponseEntity<Response> completeOrder(@PathVariable Long orderId) {

		Response response = orderService.completeOrder(orderId);

		return new ResponseEntity<>(response, HttpStatus.OK);
	}

}
