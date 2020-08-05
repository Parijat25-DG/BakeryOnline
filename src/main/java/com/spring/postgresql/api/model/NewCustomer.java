package com.spring.postgresql.api.model;

public class NewCustomer {
	
	private long id;
	private String name;
	private String mobile;
	private String email;
	private String address;
	private String dateOfBirth;
	private String dateOfAnniversary;
	private String altContactName;
	private String altContactMobile;
	private String altContactEmail;
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getDateOfAnniversary() {
		return dateOfAnniversary;
	}
	public void setDateOfAnniversary(String dateOfAnniversary) {
		this.dateOfAnniversary = dateOfAnniversary;
	}
	public String getAltContactName() {
		return altContactName;
	}
	public void setAltContactName(String altContactName) {
		this.altContactName = altContactName;
	}
	public String getAltContactMobile() {
		return altContactMobile;
	}
	public void setAltContactMobile(String altContactMobile) {
		this.altContactMobile = altContactMobile;
	}
	public String getAltContactEmail() {
		return altContactEmail;
	}
	public void setAltContactEmail(String altContactEmail) {
		this.altContactEmail = altContactEmail;
	}

}
