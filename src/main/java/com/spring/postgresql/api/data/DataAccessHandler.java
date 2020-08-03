package com.spring.postgresql.api.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.spring.postgresql.api.dto.OrderRequest;
import com.spring.postgresql.api.dto.OrderResponse;
import com.spring.postgresql.api.model.Classes;
import com.spring.postgresql.api.model.Customer;
import com.spring.postgresql.api.model.Items;
import com.spring.postgresql.api.model.Order;
import com.spring.postgresql.api.model.Parties;
import com.spring.postgresql.api.model.Shops;
import com.spring.postgresql.api.repository.ClassRepository;
import com.spring.postgresql.api.repository.CustomerRepository;
import com.spring.postgresql.api.repository.ItemRepository;
import com.spring.postgresql.api.repository.PartyRepository;
import com.spring.postgresql.api.repository.ShopRepository;

@Component
public class DataAccessHandler {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private ShopRepository shopRepository;
	
	@Autowired
	private ItemRepository itemRepository;
	
	@Autowired
	private ClassRepository classRepository;
	
	@Autowired
	private PartyRepository partyRepository;
	
	public Order mapOrderRequestDetails(OrderRequest request){
		Order order = new Order();
		order.setCategory(request.getCategory());
		if(request.getClassId() == 0) {
			order.setClassId(0);
		} else {
			order.setClassId(request.getClassId());
		}
		order.setCustomerId(request.getCustomerId());
		order.setDate(request.getDate());
		order.setDeliveryMode(request.getDeliveryMode());
		if(request.getPartyId() == 0) {
			order.setPartyId(0);
		} else {
			order.setPartyId(request.getPartyId());
		}
		order.setPaymentMode(request.getPaymentMode());
		if(request.getShopId() == 0) {
			order.setShopId(0);
		} else {
			order.setPartyId(request.getPartyId());
		}
		order.setTotalAmount(request.getTotalAmount());
		List<String> itemNames = new ArrayList<>();
		for(Integer itemId : request.getItemIds()) {
			Items items = itemRepository.findByItemId(itemId);
			itemNames.add(items.getName());
		}
		order.setItems(String.join(",", itemNames));
		return order;
	}
	
	public OrderResponse mapOrderResponseDetails(Order orderDetails) {
		OrderResponse orderResponse = new OrderResponse();
		
		orderResponse.setId(orderDetails.getId());
		orderResponse.setDate(orderDetails.getDate());
		orderResponse.setTotalAmount(orderDetails.getTotalAmount());
		orderResponse.setPaymentMode(orderDetails.getPaymentMode());
		orderResponse.setOrderStatus(orderDetails.getOrderStatus());
		orderResponse.setCategory(orderDetails.getCategory());
		
		Customer customerDetails = customerRepository.findByCustomerId(orderDetails.getCustomerId());
		
		orderResponse.setCustomerName(customerDetails.getName());
		orderResponse.setCustomerAddress(customerDetails.getAddress());
		orderResponse.setCustomerEmail(customerDetails.getEmail());
		orderResponse.setCustomerPhone(customerDetails.getPhone());
		
		if(orderDetails.getCategory().equalsIgnoreCase("individual")) {
			orderResponse.setDeliveryMode(orderDetails.getDeliveryMode());
			Shops shopDetails = shopRepository.findByShopId(orderDetails.getShopId());
			orderResponse.setShopLocation(shopDetails.getLocation());
			Map<String, Integer> itemDetails = new HashMap<>();
			String items = orderDetails.getItems();
			String[] itemArray = items.split(",");
			for(String item : itemArray) {
				Items itemObj = itemRepository.findByName(item);
				itemDetails.put(itemObj.getName(), itemObj.getPrice());
			}
			orderResponse.setItemDetails(itemDetails);
			
		} else if(orderDetails.getCategory().equalsIgnoreCase("class")) {
			Classes classDetails = classRepository.findByClassId(orderDetails.getClassId());
			orderResponse.setClassLocation(classDetails.getLocation());
			orderResponse.setCuisineToLearn(classDetails.getCuisine());
			orderResponse.setDateOfClass(classDetails.getDateOfClass());
			orderResponse.setSlotOfClass(classDetails.getSlotOfClass());
			
		} else if(orderDetails.getCategory().equalsIgnoreCase("party")) {
			Parties partyDetails = partyRepository.findByPartyId(orderDetails.getPartyId());
			orderResponse.setPartyLocation(partyDetails.getLocation());
			List<String> cuisineList = new ArrayList<>();
			cuisineList.add(partyDetails.getCuisineOne());
			if(!partyDetails.getCuisineTwo().equalsIgnoreCase("NA")) {
				cuisineList.add(partyDetails.getCuisineTwo());
			}
			if(!partyDetails.getCuisineThree().equalsIgnoreCase("NA")) {
				cuisineList.add(partyDetails.getCuisineThree());
			}
			orderResponse.setPartyCuisineList(cuisineList );
			orderResponse.setGuests(partyDetails.getGuests());
			orderResponse.setTypeOfParty(partyDetails.getTypeOfParty());
		}
		return orderResponse;
	}

}
