package com.amsidh.mvc.entities;

import javax.persistence.Embeddable;
import javax.persistence.Transient;

@Embeddable
public class Address {

	private String city;
	@Transient
	private String state;
	private Long pincode;

	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Address(String city, String state, Long pincode) {
		super();
		this.city = city;
		this.state = state;
		this.pincode = pincode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Long getPincode() {
		return pincode;
	}

	public void setPincode(Long pincode) {
		this.pincode = pincode;
	}

	@Override
	public String toString() {
		return "City: " + city + "State: " + state + " Pincode: " + pincode;
	}
}
