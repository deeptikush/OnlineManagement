package com.orderApplication.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.orderApplication.Entity.Order;
import com.orderApplication.Model.OrderRequest;


public interface OrderService {
	
	public String addOrder(OrderRequest orderRequest) throws Exception;
	
	public Order getorder(int id);
	
	public List<Order> getAllOrders();
	

}
