package com.inventory.inventory_system.mapper;

import com.inventory.inventory_system.dto.CategoryDto;
import com.inventory.inventory_system.entity.Category;

public class CategoryMapper {

	public static Category toEntity(CategoryDto categoryDto) {

		return new Category(categoryDto.getId(), categoryDto.getCategoryName(), categoryDto.getDescriptiion());
	}

	public static CategoryDto toDTO(Category category) {

		return new CategoryDto(category.getId(), category.getCategoryName(), category.getDescriptiion());
	}
}