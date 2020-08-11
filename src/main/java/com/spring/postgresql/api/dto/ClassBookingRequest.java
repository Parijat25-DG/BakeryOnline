package com.spring.postgresql.api.dto;

public class ClassBookingRequest {
	
	private int customerId;
	private String category;
	private String date;
	private String classLocation;
	private String cuisineToLearn;
	private String dateOfClass;
	private String slotOfClass;
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
