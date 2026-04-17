package com.inventory.inventory_system.customValidation;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.inventory.inventory_system.dto.ProductDto;

import com.inventory.inventory_system.exception.ValidationException;
import com.inventory.inventory_system.repositoy.ProductRepo;

@Component
public class ProductValidation {

	private final ProductRepo productRepo;
//	private final ProductDto productDto;

	public ProductValidation(ProductRepo productRepo) {
		this.productRepo = productRepo;
		
	}

//	private static final int BAD_REQUEST = 400;
	
	ProductDto productDto=new ProductDto();

	public void productValidation(ProductDto dto) { 

		// Null check
		if (dto == null) {
			throw new ValidationException(HttpStatus.BAD_REQUEST.value(), "Product data must not be null");
		}

		validateName(dto.getName());
		validatePrice(dto.getPrice());
		validateAvailableQuantity(dto.getAvailableQuantity());
		validateReservedQuantity(dto.getReservedQuantity());
		validateIfProductIsAvailable(dto.getName());

		// Business rule
		if (dto.getReservedQuantity() > dto.getAvailableQuantity()) {
			throw new ValidationException(HttpStatus.BAD_REQUEST.value(), "Reserved quantity cannot exceed available quantity", dto);
		}
	}

	private void validateName(String name) {
		if (name == null || name.trim().isEmpty()) {
			throw new ValidationException(HttpStatus.BAD_REQUEST.value(), "Product name is required");
		}

		if (name.length() > 100) {
			throw new ValidationException(HttpStatus.BAD_REQUEST.value(), "Product name must not exceed 100 characters");
		}
	}

	private void validatePrice(Double price) {
		if (price == null) {
			throw new ValidationException(HttpStatus.BAD_REQUEST.value(), "Product price is required");
		}

		if (price <= 0) {
			throw new ValidationException(HttpStatus.BAD_REQUEST.value(), "Product price must be greater than 0");
		}
	}

	private void validateAvailableQuantity(Integer quantity) {
		if (quantity == null) {
			throw new ValidationException(HttpStatus.BAD_REQUEST.value(), "Available quantity is required");
		}

		if (quantity < 0) {
			throw new ValidationException(HttpStatus.BAD_REQUEST.value(), "Available quantity cannot be negative");
		}
	}

	private void validateReservedQuantity(Integer quantity) {
		if (quantity == null) {
			throw new ValidationException(HttpStatus.BAD_REQUEST.value(), "Reserved quantity is required");
		}

		if (quantity < 0) {
			throw new ValidationException(HttpStatus.BAD_REQUEST.value(), "Reserved quantity cannot be negative");
		}
	}

	
	private void validateIfProductIsAvailable(String productName) {
		

	    if (productName == null || productName.trim().isEmpty()) {
	    	throw new ValidationException(HttpStatus.BAD_REQUEST.value(), "Product Can Not Be Empty or Null");
	    }

	    String normalizedName = productName.trim();

	    if (productRepo.existsByName(normalizedName)) {
	    	throw new ValidationException(HttpStatus.BAD_REQUEST.value(), "Product Already Exist");
	    }
	}
}
