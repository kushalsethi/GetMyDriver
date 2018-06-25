package com.kushals.model;

public class Customer {

	private String customerName;
	private double customerLatitude;
	private double customerLongitude;

	public Customer(String customerName, double customerLatitude, double customerLongitude) {
		this.customerName = customerName;
		this.customerLatitude = customerLatitude;
		this.customerLongitude = customerLongitude;
	}

	public String getCustomerName() {
		return customerName;
	}

	public double getCustomerLatitude() {
		return customerLatitude;
	}

	public double getCustomerLongitude() {
		return customerLongitude;
	}

}
