package com.inventory.inventory_system.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inventory.inventory_system.dto.CategoryDto;
import com.inventory.inventory_system.dto.Response;
import com.inventory.inventory_system.service.CategoryService;

@RequestMapping("api/category")
@RestController
public class CategoryController {
	
	
	private final CategoryService categoryService;
	
	public CategoryController(CategoryService categoryService) {
		this.categoryService=categoryService;
	}
	
	@PostMapping("/add")
	public ResponseEntity<Response>addCategory(@RequestBody CategoryDto categoryDto){
		
		Response response=categoryService.addCategory(categoryDto); 
		return new ResponseEntity<>(response, HttpStatus.CREATED);
		
	}

}
