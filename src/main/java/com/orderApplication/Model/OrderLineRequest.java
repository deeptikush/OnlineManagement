package com.orderApplication.Model;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class OrderLineRequest {
	
@NotBlank(message="not null")
@Pattern(regexp="^[a-zA-Z ]{1,50}+$" ,message = "only alphabet are allowed with maximum size 5")
 private String itemName;

//@Size(min=1, max=25 , message ="quantity must not be less then 1 and  not be exceed 25" )
@Min(value=1, message ="quantity must not be less then 1" )
@Max(value=25, message="quantity must not be exceed 25")
 private Integer quantity;
}
