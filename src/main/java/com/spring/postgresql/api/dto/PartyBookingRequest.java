package com.spring.postgresql.api.dto;

import java.util.List;

public class PartyBookingRequest {
	
	private int customerId;
	private String category;
	private String date;
	private String partyLocation;
	private List<String> partyCuisineList;
	private int guests;
	private String typeOfParty;
	private String customerName;
	private String customerEmail;
	
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getPartyLocation() {
		return partyLocation;
	}
	public void setPartyLocation(String partyLocation) {
		this.partyLocation = partyLocation;
	}
	public List<String> getPartyCuisineList() {
		return partyCuisineList;
	}
	public void setPartyCuisineList(List<String> partyCuisineList) {
		this.partyCuisineList = partyCuisineList;
	}
	public int getGuests() {
		return guests;
	}
	public void setGuests(int guests) {
		this.guests = guests;
	}
	public String getTypeOfParty() {
		return typeOfParty;
	}
	public void setTypeOfParty(String typeOfParty) {
		this.typeOfParty = typeOfParty;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomerEmail() {
		return customerEmail;
	}
	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}
	

}
