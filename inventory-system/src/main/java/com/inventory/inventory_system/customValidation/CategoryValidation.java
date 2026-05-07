package com.inventory.inventory_system.customValidation;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.inventory.inventory_system.dto.CategoryDto;

import com.inventory.inventory_system.exception.ValidationException;
import com.inventory.inventory_system.repositoy.CategoryRepo;

@Component
public class CategoryValidation {

	private final CategoryRepo categoryRepo;

	public CategoryValidation(CategoryRepo categoryRepo) {
		this.categoryRepo = categoryRepo;
	}

	public void categoryValidate(CategoryDto categoryDto) {

		if (categoryDto == null) {
			throw new ValidationException(HttpStatus.BAD_REQUEST.value(), "Category can not be empty");
		}
		if (categoryDto.getCategoryName() == null || categoryDto.getCategoryName().trim().isEmpty()) {

			throw new ValidationException(HttpStatus.BAD_REQUEST.value(), "Category name can not be empty");
		}
		if(categoryRepo.existsByCategoryNameIgnoreCase(categoryDto.getCategoryName().trim())) {
			throw new ValidationException(HttpStatus.BAD_REQUEST.value(), "Category already exist");
		}

	}

}
