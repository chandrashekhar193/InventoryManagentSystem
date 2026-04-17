package com.inventory.inventory_system.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;

import com.inventory.inventory_system.customValidation.ProductValidation;
import com.inventory.inventory_system.dto.ProductDto;
import com.inventory.inventory_system.dto.Response;
import com.inventory.inventory_system.entity.Product;
import com.inventory.inventory_system.exception.ValidationException;
import com.inventory.inventory_system.mapper.ProductMapper;
import com.inventory.inventory_system.repositoy.ProductRepo;
import com.inventory.inventory_system.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	private final ProductRepo productRepo;
	private final ProductValidation productValidation;

	public ProductServiceImpl(ProductRepo productRepo, ProductValidation productValidation) {
		this.productRepo = productRepo;
		this.productValidation = productValidation;
	}

	@Override
	public Response saveproduct(ProductDto dto) {

		productValidation.productValidation(dto);
		Product product = ProductMapper.toEntity(dto);
		Product savedProduct = productRepo.save(product);
		ProductDto responseProduct = ProductMapper.toDTO(savedProduct);
		return new Response(HttpStatus.CREATED.value(), "PRODUCT CREATED", responseProduct);
	}

	@Override
	public Response updateProduct(ProductDto dto) {
		// TODO Auto-generated method stub
		if (dto.getId() == null) {
			throw new ValidationException(HttpStatus.BAD_REQUEST.value(), "Product ID cannot be null");
		}

		Product existingProduct = productRepo.findById(dto.getId())
				.orElseThrow(() -> new ValidationException(HttpStatus.NOT_FOUND.value(), "Product not found this id "+dto.getId()));

		// Validate name if being updated
		if (dto.getName() != null) {
			String normalizedName = dto.getName().trim();

			if (productRepo.existsByName(normalizedName)
					&& !existingProduct.getName().equalsIgnoreCase(normalizedName)) {
				throw new ValidationException(HttpStatus.BAD_REQUEST.value(), "Product already exists");
			}

			existingProduct.setName(normalizedName);
		}

		// Update fields safely
		if (dto.getPrice() != null) {
			existingProduct.setPrice(dto.getPrice());
		}

		if (dto.getAvailableQuantity() != null) {
			existingProduct.setAvailableQuantity(dto.getAvailableQuantity());
		}

		if (dto.getReservedQuantity() != null) {
			existingProduct.setReservedQuantity(dto.getReservedQuantity());
		}

		Product savedProduct = productRepo.save(existingProduct);

		ProductDto responseDto = ProductMapper.toDTO(savedProduct);

		return new Response(HttpStatus.OK.value(), "Product updated successfully", responseDto);

	}

	@Override
	public Response getproductById(Long id) {

		if (id == null || id <= 0) {
			throw new ValidationException(HttpStatus.BAD_REQUEST.value(), "Invalid product id");
		}

		Product product = productRepo.findById(id).orElseThrow(
				() -> new ValidationException(HttpStatus.NOT_FOUND.value(), "Product not found with id: " + id));

		ProductDto dto = ProductMapper.toDTO(product);

		return new Response(HttpStatus.OK.value(), "Product fetched successfully", dto);
	}

	@Override
	public Response getAllProduct() {

		List<Product> products = productRepo.findAll();

		if (products.isEmpty()) {
			return new Response(HttpStatus.OK.value(), "No products found", new ArrayList<>());
		}

		List<ProductDto> productDtos = new ArrayList<>();

		for (Product product : products) {
			productDtos.add(ProductMapper.toDTO(product));
		}

		return new Response(HttpStatus.OK.value(), "Products fetched successfully", productDtos);
	}
}
