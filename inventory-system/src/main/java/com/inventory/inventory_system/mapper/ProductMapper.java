package com.inventory.inventory_system.mapper;

import com.inventory.inventory_system.dto.ProductDto;
import com.inventory.inventory_system.entity.Product;

public class ProductMapper {

	// DTO → Entity
	public static Product toEntity(ProductDto productDto) {
		return new Product(productDto.getId(), productDto.getName(), productDto.getPrice(),
				productDto.getAvailableQuantity(),
				productDto.getReservedQuantity() != null ? productDto.getReservedQuantity() : 0,productDto.getCategoryId()); 
	}

	// Entity → DTO
	public static ProductDto toDTO(Product product) {
		return new ProductDto(product.getId(), product.getName(), product.getPrice(), product.getAvailableQuantity(),
				product.getReservedQuantity() != null ? product.getReservedQuantity() : 0,product.getCategoryId());
	}
}
