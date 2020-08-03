package com.spring.postgresql.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PARTIES")
public class Parties {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name = "PARTY_ID")
	private int id;
	@Column(name = "LOCATION")
	private String location;
	@Column(name = "CUISINE_ONE")
	private String cuisineOne;
	@Column(name = "CUISINE_TWO")
	private String cuisineTwo;
	@Column(name = "CUISINE_THREE")
	private String cuisineThree;
	@Column(name = "GUESTS")
	private int guests;
	@Column(name = "TYPE")
	private String typeOfParty;
	@Column(name = "PACKAGE")
	private String partyPackage;
	
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
	
	public String getCuisineOne() {
		return cuisineOne;
	}
	public void setCuisineOne(String cuisineOne) {
		this.cuisineOne = cuisineOne;
	}
	public String getCuisineTwo() {
		return cuisineTwo;
	}
	public void setCuisineTwo(String cuisineTwo) {
		this.cuisineTwo = cuisineTwo;
	}
	public String getCuisineThree() {
		return cuisineThree;
	}
	public void setCuisineThree(String cuisineThree) {
		this.cuisineThree = cuisineThree;
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
	public String getPartyPackage() {
		return partyPackage;
	}
	public void setPartyPackage(String partyPackage) {
		this.partyPackage = partyPackage;
	}
	
	
}
