package com.inventory.inventory_system.dto;

public class Response {
	
	private Integer statusCode;
    private String status;
    private Object data;
    private Integer currentPage;
    private Long totalItems;
    private Integer totalPages;
    
    
	public Integer getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	
	public Integer getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}
	public Long getTotalItems() {
		return totalItems;
	}
	public void setTotalItems(Long totalItems) {
		this.totalItems = totalItems;
	}
	public Integer getTotalPages() {
		return totalPages;
	}
	public void setTotalPages(Integer totalPages) {
		this.totalPages = totalPages;
	}
	public Response(Integer statusCode, String status, Object data) {
//		super();
		this.statusCode = statusCode;
		this.status = status;
		this.data = data;
	}
	public Response(Integer statusCode, String status) {
//		super();
		this.statusCode = statusCode;
		this.status = status;
		
	}
	
	public Response(Integer statusCode, String status,Object data,Integer currentPage,Long totalItems ,Integer totalPages) {
//		super();
		this.statusCode = statusCode;
		this.status = status;
		this.currentPage=currentPage;
		this.totalItems=totalItems;
		this.totalPages=totalPages;
		this.data=data;
		
		
	}
	public Response() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Response [statusCode=" + statusCode + ", status=" + status + ", data=" + data + ", currentPage="
				+ currentPage + ", totalItems=" + totalItems + ", totalPages=" + totalPages + "]";
	}
	
    
    

}
