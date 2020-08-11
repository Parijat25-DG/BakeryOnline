package com.spring.postgresql.api.data;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.spring.postgresql.api.dto.BookingResponse;
import com.spring.postgresql.api.dto.ClassBookingRequest;
import com.spring.postgresql.api.dto.OrderBookingRequest;
import com.spring.postgresql.api.dto.PartyBookingRequest;
import com.spring.postgresql.api.model.Classes;
import com.spring.postgresql.api.model.Customer;
import com.spring.postgresql.api.model.Items;
import com.spring.postgresql.api.model.Order;
import com.spring.postgresql.api.model.Parties;
import com.spring.postgresql.api.model.Shops;
import com.spring.postgresql.api.repository.ClassRepository;
import com.spring.postgresql.api.repository.CustomerRepository;
import com.spring.postgresql.api.repository.ItemRepository;
import com.spring.postgresql.api.repository.OrderRepository;
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
	
	@Autowired
	private OrderRepository orderRepository;

	public BookingResponse saveOrderBooking(OrderBookingRequest request) {
		Order order = new Order();
		order.setCategory(request.getCategory());
		order.setDate(request.getDate());
		order.setDeliveryMode(request.getDeliveryMode());
		order.setPaymentMode(request.getPaymentMode());
		
		Customer customer = customerRepository.findByNameAndEmail(request.getCustomerName(), request.getCustomerEmail());
		order.setCustomerId(customer.getId());
		
		Shops shop = shopRepository.findByShopLocation(request.getShopLocation());
		order.setShopId(shop.getId());
		
		StringBuilder items = new StringBuilder();
		int itemCost = 0;
		for(Entry<String, Integer> entrySet : request.getItemDetails().entrySet()) {
			Items item = itemRepository.findByName(entrySet.getKey());
			int pricePerItem = item.getPrice();
			itemCost = itemCost + pricePerItem*entrySet.getValue();
			items.append(item.getName()).append(",");
		}
		order.setItems(items.toString());
		order.setTotalAmount(itemCost);
		
		Order savedOrder = orderRepository.save(order);
		BookingResponse response = new BookingResponse();
		response.setBookingId(savedOrder.getId());
		response.setTotalAmount(itemCost);
		response.setBookingStatus("CREATED");
		return response;
	}

	public BookingResponse savePartyBooking(PartyBookingRequest request) {
		Order order = new Order();
		order.setCategory(request.getCategory());
		order.setDate(request.getDate());
		
		Customer customer = customerRepository.findByNameAndEmail(request.getCustomerName(), request.getCustomerEmail());
		order.setCustomerId(customer.getId());
		
		int partyCost = 0;
		int partyId = 0;
		List<Parties> parties = partyRepository.findByType(request.getTypeOfParty());
		for(Parties party : parties) {
			if(party.getLocation().equalsIgnoreCase(request.getPartyLocation())) {
				Collection<String> cuisines = new ArrayList<String>();
				cuisines.add(party.getCuisineOne());
				cuisines.add(party.getCuisineTwo());
				cuisines.add(party.getCuisineThree());
				if(request.getPartyCuisineList().containsAll(cuisines)) {
					if(request.getGuests()>=party.getGuests()) {
						partyCost = partyCost+party.getPartyPackage()*request.getGuests();
						partyId = party.getId();
					}
				}
			}
		}
		order.setPartyId(partyId);
		order.setTotalAmount(partyCost);
		
		Order savedOrder = orderRepository.save(order);
		BookingResponse response = new BookingResponse();
		response.setBookingId(savedOrder.getId());
		response.setTotalAmount(partyCost);
		response.setBookingStatus("PAID");
		return response;
	}

	public BookingResponse saveClassBooking(ClassBookingRequest request) {
		Order order = new Order();
		order.setCategory(request.getCategory());
		order.setDate(request.getDate());
		
		Customer customer = customerRepository.findByNameAndEmail(request.getCustomerName(), request.getCustomerEmail());
		order.setCustomerId(customer.getId());
		
		int classCost = 0;
		int classId = 0;
		List<Classes> classes = classRepository.findByCuisine(request.getCuisineToLearn());
		for(Classes aclass : classes) {
			request.getDateOfClass();
			request.getSlotOfClass();
			if(aclass.getSeatsAvailable()>0) {
				if(aclass.getLocation().equalsIgnoreCase(request.getClassLocation())
					&& aclass.getSlotOfClass().equalsIgnoreCase(request.getSlotOfClass())
						&& aclass.getDateOfClass().equalsIgnoreCase(request.getDateOfClass())) {
					classId = aclass.getId();
					classCost = aclass.getCostOfClass();
				}
					
			}
		}
		order.setClassId(classId);
		order.setTotalAmount(classCost);
		
		Order savedOrder = orderRepository.save(order);
		BookingResponse response = new BookingResponse();
		response.setBookingId(savedOrder.getId());
		response.setTotalAmount(classCost);
		response.setBookingStatus("BOOKED");
		return response;
	}

	public BookingResponse mapOrderResponseDetails(Order order) {
		BookingResponse response = new BookingResponse();
		Order savedOrder = orderRepository.findById(order.getId()).get();
		response.setBookingId(savedOrder.getId());
		response.setTotalAmount(savedOrder.getTotalAmount());
		response.setBookingStatus(savedOrder.getOrderStatus());
		return response;
	}

}
