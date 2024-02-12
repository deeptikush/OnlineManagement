package com.orderApplication.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
public class OrderAlreadyExistsException extends RuntimeException {
	
	
	private boolean success;
	private String message;
	
	
	
	
	
}


