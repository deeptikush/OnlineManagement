package com.orderApplication.Model;


import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data

public class OrderRequest {
	
	private int id;
	@Min(value = 1, message="not less then 1" )
	private long amount;
	
	@NotBlank (message= "Name is mandatory")
	@Pattern(regexp="^[a-zA-Z ]{1,50}+$" ,message = "only alphabet are allowed with maximum size 5")
	private String orderName;

}
