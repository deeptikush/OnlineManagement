package com.orderApplication.controller;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.orderApplication.Model.OrderRequest;
import com.orderApplication.payload.SuccessResponse;
import com.orderApplication.service.OrderService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/order")
public class OrderController {

	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(OrderController.class);

	@Autowired
	OrderService orderService;

	@PostMapping("/addOrder")
	public ResponseEntity<SuccessResponse> addOrder(@Valid @RequestBody OrderRequest orderRequest) throws Exception {

		orderService.addOrder(orderRequest);
		logger.info("order info " + orderRequest.getOrderName());
		return ResponseEntity.status(HttpStatus.CREATED).body(new SuccessResponse(true, "Order created successfully"));

	}

}
