package com.inventory.inventory_system.service;

import com.inventory.inventory_system.dto.ProductDto;
import com.inventory.inventory_system.dto.ProductFilterDto;
import com.inventory.inventory_system.dto.Response;

public interface ProductService {

	// save Product
	Response saveproduct(ProductDto dto);

	Response updateProduct(ProductDto dto);

	Response getproductById(Long id);

	Response getAllProduct();

	Response deleteProduct(Long id);

	Response getFilteredProducts(ProductFilterDto dto , int page, int size, String sortBy);

}