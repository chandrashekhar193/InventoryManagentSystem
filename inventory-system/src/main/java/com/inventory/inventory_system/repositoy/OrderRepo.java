package com.inventory.inventory_system.repositoy;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inventory.inventory_system.entity.Order;


@Repository
public interface OrderRepo extends JpaRepository<Order, Long> {

} 
