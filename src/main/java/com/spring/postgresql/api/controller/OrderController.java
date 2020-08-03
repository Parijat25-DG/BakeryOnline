package com.spring.postgresql.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.postgresql.api.data.DataAccessHandler;
import com.spring.postgresql.api.dto.OrderRequest;
import com.spring.postgresql.api.dto.OrderResponse;
import com.spring.postgresql.api.repository.OrderRepository;

@RestController
@RequestMapping("/api")
public class OrderController {

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private DataAccessHandler dataAccessHandler;

	@GetMapping("/getOrderDetails/{orderId}")
	public OrderResponse fetchOrderDetails(@PathVariable String orderId){
		return dataAccessHandler.mapOrderResponseDetails(orderRepository.findByOrderId(Integer.parseInt(orderId)));
	}

	@PostMapping("/saveOrderDetails")
	public int saveOrderDetails(@RequestBody OrderRequest request) {
		return orderRepository.save(dataAccessHandler.mapOrderRequestDetails(request)).getId();
	}

}
