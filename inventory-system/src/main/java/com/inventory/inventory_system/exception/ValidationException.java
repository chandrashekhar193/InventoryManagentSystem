package com.inventory.inventory_system.exception;

public class ValidationException extends RuntimeException {
	
	private int statusCode;
	private String message;
	private Object data;

	public ValidationException(int statusCode, String message, Object data) {
		super(message); 
		this.statusCode = statusCode;
		this.message = message;
		this.data = data;
	}

	public ValidationException(int statusCode, String message) {
		super(message); 
		this.statusCode = statusCode;
		this.message = message;
	}

}
