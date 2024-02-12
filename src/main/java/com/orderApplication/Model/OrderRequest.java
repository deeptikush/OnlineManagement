package com.orderApplication.Model;


import java.util.List;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
public class OrderRequest {
	
	
	@Min(value = 1, message="not less then 1" )
	private long amount;
	
	@NotBlank (message= "Name is mandatory")
	@Pattern(regexp="^[a-zA-Z ]{1,50}+$" ,message = "only alphabet are allowed with maximum size 5")
	private String orderName;
    @Valid
    @NotNull(message="orderline not be null")
    @Size(min=1,message="minimum orderLine  must be 1")
	private List<OrderLineRequest> orderLines; 
	

}
