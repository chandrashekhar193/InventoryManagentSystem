package com.inventory.inventory_system.service;

import com.inventory.inventory_system.dto.Response;

public interface OrderService {
	
	Response placeOrder(Long id , Integer quantity);
	
	Response cancelOrder(Long orderId);
	
	Response completeOrder(Long orderId);
	 

}
