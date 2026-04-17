package com.inventory.inventory_system.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inventory.inventory_system.dto.ProductDto;
import com.inventory.inventory_system.dto.Response;
import com.inventory.inventory_system.entity.Product;
import com.inventory.inventory_system.service.ProductService;

@RestController
@RequestMapping("/api/product")
public class ProductController {

	private final ProductService productService;

	public ProductController(ProductService productService) {
		this.productService = productService;
	} 

	@PostMapping("/save")
	public ResponseEntity<Response> saveProduct(@RequestBody ProductDto dto) {
		Response response = productService.saveproduct(dto);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@PostMapping("/update")
	public ResponseEntity<Response> updateProduct(@RequestBody ProductDto dto) {

		Response response = productService.updateProduct(dto);

		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Response> getProductById(@PathVariable Long id) {

		Response response = productService.getproductById(id);

		return new ResponseEntity<>(response, HttpStatus.OK);
	} 

	@GetMapping("/getAll")
	public ResponseEntity<Response> getAllProducts() {

		Response response = productService.getAllProduct();

		return new ResponseEntity<>(response, HttpStatus.OK);
	}

}