package com.kushals.model;

public class DriverStatusResponse {
	private String driverName;
	private String customerName;
	private Status status;

	public DriverStatusResponse(String driverName, String customerName, boolean status) {
		super();
		this.driverName = driverName;
		this.customerName = customerName;
		this.status = status ? Status.BUSY : Status.AVAILABLE;
	}

	public String getDriverName() {
		return driverName;
	}

	public String getCustomerName() {
		return customerName;
	}

	public Status getStatus() {
		return status;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public void setStatus(boolean status) {
		this.status = status ? Status.BUSY : Status.AVAILABLE;
	}

	public enum Status {
		AVAILABLE, BUSY;
	}

	@Override
	public String toString() {
		return "DriverStatusResponse [driverName=" + driverName + ", customerName=" + customerName + ", status="
				+ status + "]";
	}
	
	

}
