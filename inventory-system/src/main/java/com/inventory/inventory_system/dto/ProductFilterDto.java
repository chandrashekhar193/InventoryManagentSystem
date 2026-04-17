package com.inventory.inventory_system.dto;

public class ProductFilterDto {

	private String name;
	private Double minPrice;
	private Double maxPrice;
	private Integer minAvailableQuantity;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getMinPrice() {
		return minPrice;
	}
	public void setMinPrice(Double minPrice) {
		this.minPrice = minPrice;
	}
	public Double getMaxPrice() {
		return maxPrice;
	}
	public void setMaxPrice(Double maxPrice) {
		this.maxPrice = maxPrice;
	}
	public Integer getMinAvailableQuantity() {
		return minAvailableQuantity;
	}
	public void setMinAvailableQuantity(Integer minAvailableQuantity) {
		this.minAvailableQuantity = minAvailableQuantity;
	}
	public ProductFilterDto(String name, Double minPrice, Double maxPrice, Integer minAvailableQuantity) {
		super();
		this.name = name;
		this.minPrice = minPrice;
		this.maxPrice = maxPrice;
		this.minAvailableQuantity = minAvailableQuantity;
	}
	public ProductFilterDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "ProductFilterDto [name=" + name + ", minPrice=" + minPrice + ", maxPrice=" + maxPrice
				+ ", minAvailableQuantity=" + minAvailableQuantity + "]";
	}
	
	
}
