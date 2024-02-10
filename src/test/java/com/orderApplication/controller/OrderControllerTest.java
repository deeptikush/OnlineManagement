package com.orderApplication.controller;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import com.orderApplication.Model.OrderRequest;
import com.orderApplication.payload.SuccessResponse;
import com.orderApplication.service.OrderService;



@ExtendWith(MockitoExtension.class)
public class OrderControllerTest  {

@InjectMocks
OrderController orderController;

@Mock 
OrderService orderService;

@Test
void testAddOrder() throws Exception {
	OrderRequest orderRequest =new OrderRequest();
	
	String s="pass";
	when(orderService.addOrder(orderRequest)).thenReturn(s);
	ResponseEntity<SuccessResponse> response=	orderController.addOrder(orderRequest);
	verify(orderService,times(1)).addOrder(orderRequest);
    
}

}
