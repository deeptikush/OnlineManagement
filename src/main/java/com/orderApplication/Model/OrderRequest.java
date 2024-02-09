package com.orderApplication.Model;

import org.springframework.validation.annotation.Validated;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
@Validated
public class OrderRequest {
	
	private int id;
	@Min(value = 1, message="not less then 1" )
	private long amount;
	
	@NotBlank (message= "Name is mandatory")
	private String orderName;

}
