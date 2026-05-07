package com.inventory.inventory_system.service;

import com.inventory.inventory_system.dto.CategoryDto;
import com.inventory.inventory_system.dto.Response;

public interface CategoryService {
	
	Response addCategory(CategoryDto categoryDto);
	Response updateCategory(CategoryDto categoryDto);
	Response getAllCategory();
	Response getCategoryById(Long id);

}
