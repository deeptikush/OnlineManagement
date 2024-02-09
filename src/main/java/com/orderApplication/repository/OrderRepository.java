package com.orderApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.orderApplication.Entity.Order;

public interface OrderRepository extends JpaRepository<Order, Integer>{
	
	@Query(value="select order_name from order_table where order_name= :orderName",nativeQuery=true)
	public String getOrdeNameByQ(String orderName);
	

}
