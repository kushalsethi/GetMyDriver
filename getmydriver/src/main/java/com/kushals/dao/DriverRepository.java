package com.kushals.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.kushals.model.Driver;

@Repository
public class DriverRepository {

	private List<Driver> driversList = new ArrayList<>();

	public DriverRepository() {
		addDriversToList();
	}

	private void addDriversToList() {
		driversList.add(new Driver("Bob", 19.218331, 72.978090, false)); // thane-location
		driversList.add(new Driver("Harry", 19.119677, 72.905081, false)); // powai-location
		driversList.add(new Driver("Peter", 19.079024, 72.908012, false)); // ghatkopar-location
		driversList.add(new Driver("John", 19.102769, 73.009001, false)); // koparkhairan-location
		driversList.add(new Driver("Rob", 19.077064, 72.998992, false)); // vashi-location
	}

	public List<Driver> getDrivers() {
		return this.driversList;
	}

	public void setDriverStatus(Driver driver, boolean status) {
		driversList.stream().filter(currentDriver -> currentDriver.equals(driver)).findFirst().get().setStatus(status);
	}

}
