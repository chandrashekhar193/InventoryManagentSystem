package com.inventory.inventory_system.dto;

public class CategoryDto {
	private Long id;
	private String categoryName;
	private String description;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getDescriptiion() {
		return description;
	}
	public void setDescriptiion(String descriptiion) {
		this.description = descriptiion;
	}
	public CategoryDto(Long id, String categoryName, String description) {
		super();
		this.id = id;
		this.categoryName = categoryName;
		this.description = description;
	}
	public CategoryDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "CategoryDto [id=" + id + ", categoryName=" + categoryName + ", description=" + description + "]";
	}
	
	
	

}
