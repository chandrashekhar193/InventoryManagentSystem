package com.inventory.inventory_system.serviceImpl;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.inventory.inventory_system.customValidation.CategoryValidation;
import com.inventory.inventory_system.dto.CategoryDto;
import com.inventory.inventory_system.dto.Response;
import com.inventory.inventory_system.entity.Category;
import com.inventory.inventory_system.mapper.CategoryMapper;
import com.inventory.inventory_system.repositoy.CategoryRepo;
import com.inventory.inventory_system.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	private final CategoryValidation categoryValidation;
	private final CategoryRepo categoryRepo;

	public CategoryServiceImpl(CategoryValidation categoryValidation, CategoryRepo categoryRepo) {
		this.categoryValidation = categoryValidation;
		this.categoryRepo = categoryRepo;
	}

	@Override
	public Response addCategory(CategoryDto categoryDto) {
		// TODO Auto-generated method stub
		categoryValidation.categoryValidate(categoryDto);
		Category category = CategoryMapper.toEntity(categoryDto);
		Category savedCategory=categoryRepo.save(category);
		CategoryDto responseDto=CategoryMapper.toDTO(savedCategory);
		return new Response(HttpStatus.CREATED.value(),"Category Created Successfully ",responseDto);
	}

	@Override
	public Response updateCategory(CategoryDto categoryDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response getAllCategory() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response getCategoryById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
