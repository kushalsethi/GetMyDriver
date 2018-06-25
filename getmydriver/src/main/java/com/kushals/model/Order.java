package com.kushals.model;

public class Order {
	private int orderNumber;
	private String customerName;
	private double customerLatitude;
	private double customerLongitude;

	public Order() {

	}

	public Order(int orderNumber, String customerName, double customerLatitude, double customerLongitude) {
		super();
		this.orderNumber = orderNumber;
		this.customerName = customerName;
		this.customerLatitude = customerLatitude;
		this.customerLongitude = customerLongitude;
	}

	public int getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(int orderNumber) {
		this.orderNumber = orderNumber;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public double getCustomerLatitude() {
		return customerLatitude;
	}

	public void setCustomerLatitude(double customerLatitude) {
		this.customerLatitude = customerLatitude;
	}

	public double getCustomerLongitude() {
		return customerLongitude;
	}

	public void setCustomerLongitude(double customerLongitude) {
		this.customerLongitude = customerLongitude;
	}

	@Override
	public String toString() {
		return "Order [orderNumber=" + orderNumber + ", customerName=" + customerName + ", customerLatitude="
				+ customerLatitude + ", customerLongitude=" + customerLongitude + "]";
	}

}
