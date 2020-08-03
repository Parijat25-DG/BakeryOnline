package com.spring.postgresql.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CLASSES")
public class Classes {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name = "CLASS_ID")
	private int id;
	@Column(name = "LOCATION")
	private String location;
	@Column(name = "CUISINE")
	private String cuisine;
	@Column(name = "SEATS_AVAILABLE")
	private int seatsAvailable;
	@Column(name = "DATE")
	private String dateOfClass;
	@Column(name = "SLOT")
	private String slotOfClass;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getCuisine() {
		return cuisine;
	}
	public void setCuisine(String cuisine) {
		this.cuisine = cuisine;
	}
	public int getSeatsAvailable() {
		return seatsAvailable;
	}
	public void setSeatsAvailable(int seatsAvailable) {
		this.seatsAvailable = seatsAvailable;
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
	
}
