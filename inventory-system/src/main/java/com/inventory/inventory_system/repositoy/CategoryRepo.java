package com.inventory.inventory_system.repositoy;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inventory.inventory_system.entity.Category;

public interface CategoryRepo extends JpaRepository<Category, Long> {
	boolean existsByCategoryNameIgnoreCase(String categoryName);

}
