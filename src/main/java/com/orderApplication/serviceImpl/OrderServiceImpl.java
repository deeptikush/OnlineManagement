package com.orderApplication.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orderApplication.Entity.Order;
import com.orderApplication.Entity.OrderLine;
import com.orderApplication.Model.OrderLineRequest;
import com.orderApplication.Model.OrderRequest;
import com.orderApplication.repository.OrderLineRepository;
import com.orderApplication.repository.OrderRepository;
import com.orderApplication.service.OrderService;

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
	
	@Autowired
	OrderLineRepository orderLineRepository;
	
	
	@Override
	public String addOrder(OrderRequest orderRequest) throws Exception {

		Order order = convertOrderRequestToOrder(orderRequest);
		List<OrderLine> orderLines = createOrderLineRequestToOrder(orderRequest.getOrderLines(), order);
		order.setOrderLines(orderLines);

		/*
		 * String orderName = orderRepository.getOrdeNameByQ(order.getOrderName());
		 * if(orderName!=null) { throw new
		 * OrderAlreadyExistsException(false,"order already exists"); }
		 */
		/*
		 * String sqlQuery=
		 * "select order_name from order_table where order_name="+order.getOrderName()+
		 * ""; if(sqlQuery!=null) { return "user already exist"; }
		 */

		orderRepository.save(order);
		orderLineRepository.saveAll(orderLines);

		return "order is created";

	}
	
	private List<OrderLine> createOrderLineRequestToOrder(final List<OrderLineRequest> orderLinesRequest,final Order order) {
		final List<OrderLine> orderLines = new ArrayList<>();
		
		for(OrderLineRequest orderLineRequest:orderLinesRequest)
		{
			final OrderLine orderLine = new OrderLine();
			orderLine.setQuantity(orderLineRequest.getQuantity());
			orderLine.setItemName(orderLineRequest.getItemName());
			orderLine.setOrder(order);
			orderLines.add(orderLine);
			
		}
		
		return orderLines;
	}

	private static Order convertOrderRequestToOrder(OrderRequest orderRequest)
	{
		Order order = new Order();
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
