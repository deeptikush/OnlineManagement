package com.orderApplication.payload;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;



@AllArgsConstructor
@Builder
@Data
public class SuccessResponse {
	
	
	private boolean success;
	private String message;
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	

	
}

