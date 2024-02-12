package com.orderApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.orderApplication.Entity.OrderLine;

public interface OrderLineRepository extends JpaRepository<OrderLine, Integer>{

}
