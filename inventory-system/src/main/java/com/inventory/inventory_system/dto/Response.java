package com.inventory.inventory_system.dto;

public class Response {
	
	private Integer statusCode;
    private String status;
    private Object data;
    
    
    
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
	public Response() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Response [statusCode=" + statusCode + ", status=" + status + ", data=" + data + "]";
	}
    
    

}
