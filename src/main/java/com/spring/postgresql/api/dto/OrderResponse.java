package com.spring.postgresql.api.dto;

import java.util.List;
import java.util.Map;

public class OrderResponse {
	
	private int id;
	private String category;
	private String date;
	private int totalAmount;
	private String paymentMode;
	private String deliveryMode;
	private String orderStatus;
	private String shopLocation;
	private String classLocation;
	private String cuisineToLearn;
	private String dateOfClass;
	private String slotOfClass;
	private String partyLocation;
	private List<String> partyCuisineList;
	private int guests;
	private String typeOfParty;
	private String customerName;
	private String customerAddress;
	private String customerEmail;
	private String customerPhone;
	private Map<String,Integer> itemDetails;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(int totalAmount) {
		this.totalAmount = totalAmount;
	}
	public String getPaymentMode() {
		return paymentMode;
	}
	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}
	public String getDeliveryMode() {
		return deliveryMode;
	}
	public void setDeliveryMode(String deliveryMode) {
		this.deliveryMode = deliveryMode;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	public String getShopLocation() {
		return shopLocation;
	}
	public void setShopLocation(String shopLocation) {
		this.shopLocation = shopLocation;
	}
	public String getClassLocation() {
		return classLocation;
	}
	public void setClassLocation(String classLocation) {
		this.classLocation = classLocation;
	}
	public String getCuisineToLearn() {
		return cuisineToLearn;
	}
	public void setCuisineToLearn(String cuisineToLearn) {
		this.cuisineToLearn = cuisineToLearn;
	}
	public String getDateOfClass() {
		return dateOfClass;
	}
	public void setDateOfClass(String dateOfClass) {
		this.dateOfClass = dateOfClass;
	}
	public String getSlotOfClass() {
		return slotOfClass;
	}
	public void setSlotOfClass(String slotOfClass) {
		this.slotOfClass = slotOfClass;
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
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomerAddress() {
		return customerAddress;
	}
	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}
	public String getCustomerEmail() {
		return customerEmail;
	}
	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}
	public String getCustomerPhone() {
		return customerPhone;
	}
	public void setCustomerPhone(String customerPhone) {
		this.customerPhone = customerPhone;
	}
	public Map<String, Integer> getItemDetails() {
		return itemDetails;
	}
	public void setItemDetails(Map<String, Integer> itemDetails) {
		this.itemDetails = itemDetails;
	}
	
	

}
