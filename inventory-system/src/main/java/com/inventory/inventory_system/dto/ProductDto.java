package com.inventory.inventory_system.dto;


public class ProductDto {

	private Long id;
	private String name;
	private Double price;

	private Integer availableQuantity;
	private Integer reservedQuantity;
	
	private Long categoryId;
	
	
	
	public ProductDto(Long id, String name, Double price, Integer availableQuantity, Integer reservedQuantity,Long categoryId) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.availableQuantity = availableQuantity;
		this.reservedQuantity = reservedQuantity;
		this.categoryId=categoryId;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Integer getAvailableQuantity() {
		return availableQuantity;
	}
	public void setAvailableQuantity(Integer availableQuantity) {
		this.availableQuantity = availableQuantity;
	}
	public Integer getReservedQuantity() {
		return reservedQuantity;
	}
	public void setReservedQuantity(Integer reservedQuantity) {
		this.reservedQuantity = reservedQuantity;
	}
	
	public Long getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}
	public ProductDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "ProductDto [id=" + id + ", name=" + name + ", price=" + price + ", availableQuantity="
				+ availableQuantity + ", reservedQuantity=" + reservedQuantity + ", categoryId=" + categoryId + "]";
	}
	
	
	
}
