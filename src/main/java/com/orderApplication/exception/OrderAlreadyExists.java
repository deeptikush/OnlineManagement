package com.orderApplication.exception;


public class OrderAlreadyExists extends RuntimeException {
	
	
	public OrderAlreadyExists() {
		super("Order already exists ||");
	}
	
	public OrderAlreadyExists(String message) {
		super(message);
	}

	
}


