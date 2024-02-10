package com.orderApplication.serviceTest;

import static org.hamcrest.CoreMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.util.ReflectionTestUtils;

import com.orderApplication.repository.OrderRepository;
import com.orderApplication.serviceImpl.OrderServiceImpl;
import com.orderApplication.Entity.Order;
import com.orderApplication.Model.OrderRequest;

@ExtendWith(MockitoExtension.class)
public class OrderServiceimplTest {
	
	@InjectMocks
	OrderServiceImpl orderServiceImpl;
	
	@Mock
	OrderRepository orderRepository;
	
	
	
	@Test
	void addOrder() throws Exception {
		ReflectionTestUtils.setField(orderServiceImpl, "orderRepository", orderRepository);
		Order order =new Order();
		order.setOrderName("apple");
		OrderRequest orderRequest=new OrderRequest();
		orderRequest.setOrderName("apple");
		
		
		when(orderRepository.getOrdeNameByQ(order.getOrderName())).thenReturn(null);
		when(orderRepository.save(order)).thenReturn(order);
		
		orderServiceImpl.addOrder(orderRequest);
		verify(orderRepository, times(1)).getOrdeNameByQ(order.getOrderName());
		verify(orderRepository,times(1)).save(order);
		
		
		
	}
	
	
	
	

}
