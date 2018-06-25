package com.kushals.model;

public class Driver {
	private String driverName;
	private double currentLatitude;
	private double currentLongitude;
	private boolean status;

	public Driver() {

	}

	public Driver(String driverName, double currentLatitude, double currentLongitude, boolean status) {
		super();
		this.driverName = driverName;
		this.currentLatitude = currentLatitude;
		this.currentLongitude = currentLongitude;
		this.status = status;
	}

	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	public double getCurrentLatitude() {
		return currentLatitude;
	}

	public void setCurrentLatitude(double currentLatitude) {
		this.currentLatitude = currentLatitude;
	}

	public double getCurrentLongitude() {
		return currentLongitude;
	}

	public void setCurrentLongitude(double currentLongitude) {
		this.currentLongitude = currentLongitude;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Driver other = (Driver) obj;
		if (Double.doubleToLongBits(currentLatitude) != Double.doubleToLongBits(other.currentLatitude))
			return false;
		if (Double.doubleToLongBits(currentLongitude) != Double.doubleToLongBits(other.currentLongitude))
			return false;
		if (driverName == null) {
			if (other.driverName != null)
				return false;
		} else if (!driverName.equals(other.driverName))
			return false;
		if (status != other.status)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Driver [driverName=" + driverName + ", currentLatitude=" + currentLatitude + ", currentLongitude="
				+ currentLongitude + ", status=" + status + "]";
	}
	
	

}
