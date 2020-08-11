package com.spring.postgresql.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.postgresql.api.data.DataAccessHandler;
import com.spring.postgresql.api.dto.BookingResponse;
import com.spring.postgresql.api.dto.ClassBookingRequest;
import com.spring.postgresql.api.dto.OrderBookingRequest;
import com.spring.postgresql.api.dto.PartyBookingRequest;
import com.spring.postgresql.api.repository.OrderRepository;

@RestController
@RequestMapping("/api")
public class OrderController {

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private DataAccessHandler dataAccessHandler;

	@GetMapping("/getOrderDetails/{orderId}")
	public BookingResponse fetchOrderDetails(@PathVariable String orderId){
		return dataAccessHandler.mapOrderResponseDetails(orderRepository.findByOrderId(Integer.parseInt(orderId)));
	}

	@PostMapping("/saveOrderDetails")
	public BookingResponse saveOrderDetails(@RequestBody OrderBookingRequest request) {
		return dataAccessHandler.saveOrderBooking(request);
	}
	
	@PostMapping("/saveClassDetails")
	public BookingResponse saveClassDetails(@RequestBody ClassBookingRequest request) {
		return dataAccessHandler.saveClassBooking(request);
	}
	
	@PostMapping("/savePartyDetails")
	public BookingResponse savePartyDetails(@RequestBody PartyBookingRequest request) {
		return dataAccessHandler.savePartyBooking(request);
	}

}
