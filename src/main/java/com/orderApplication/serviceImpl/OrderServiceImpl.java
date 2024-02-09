package com.orderApplication.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.orderApplication.Entity.Order;
import com.orderApplication.Model.OrderRequest;
import com.orderApplication.repository.OrderRepository;
import com.orderApplication.service.OrderService;
import com.orderApplication.exception.OrderAlreadyExists;

import jakarta.persistence.EntityManager;

@Service
public class OrderServiceImpl implements OrderService{

	private  final  EntityManager entityManager;
	public OrderServiceImpl(EntityManager entityManager)
	{
		this.entityManager= entityManager;
	}
	
	@Autowired
	OrderRepository orderRepository;
	
	
	@Override
	public String addOrder(OrderRequest orderRequest) throws Exception {

		Order order = convertOrderRequestToOrder(orderRequest);

		String orderName = orderRepository.getOrdeNameByQ(order.getOrderName());
		if(orderName!=null)
		{
			throw new OrderAlreadyExists();
		}
		/*String sqlQuery= "select order_name from order_table where order_name="+order.getOrderName()+ "";
		if(sqlQuery!=null)
		{
			return "user already exist";
		}*/
		
		
			orderRepository.save(order);

	
		
		return "order is created";

	}
	
	private static Order convertOrderRequestToOrder(OrderRequest orderRequest)
	{
		Order order = new Order();
		order.setId(orderRequest.getId());
		order.setAmount(orderRequest.getAmount());
		order.setOrderName(orderRequest.getOrderName());
		
		return order;
	}

	@Override
	public Order getorder(int id) {
		
		return null;
	}
	
	/*
	 * public static String getOrderByName(Order order) {
	 * 
	 * String
	 * orderName="select order_name from order_table where order_name="+order.
	 * getOrderName()+ "";
	 * 
	 * return null;
	 * 
	 * }
	 */

	@Override
	public List<Order> getAllOrders() {
		// TODO Auto-generated method stub
		return null;
	}

}
