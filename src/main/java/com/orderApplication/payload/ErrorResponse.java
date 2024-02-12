package com.orderApplication.payload;

import java.util.List;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponse {
	
	
	private boolean status;
	private String message;
	private List<Map<String, String >> filedOfErrors ;
	
	
	
	
	}
