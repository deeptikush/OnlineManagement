package com.orderApplication.payload;

import java.util.List;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorMessage {
	
	
	private boolean status;
	private String message;
	private Map<String, String > filedOfErrors ;
	
	}
