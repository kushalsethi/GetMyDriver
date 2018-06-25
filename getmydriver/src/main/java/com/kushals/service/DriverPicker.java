package com.kushals.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kushals.dao.DriverRepository;
import com.kushals.dao.OrderRepository;
import com.kushals.model.Customer;
import com.kushals.model.Driver;
import com.kushals.model.DriverStatusResponse;
import com.kushals.model.Order;

@Service
public class DriverPicker {

	private List<DriverStatusResponse> driverStatusResponseList = new ArrayList<>();

	@Autowired
	private DriverRepository driverRepository;

	@Autowired
	private OrderRepository orderRepository;

	@PostConstruct
	public void init() {
		intializeDriverResponseList();
	}

	private void intializeDriverResponseList() {
		List<Driver> driversList = driverRepository.getDrivers();
		driversList.forEach(driver -> {
			DriverStatusResponse driverStatusResponse = new DriverStatusResponse(driver.getDriverName(), "-",
					driver.isStatus());
			driverStatusResponseList.add(driverStatusResponse);
		});
	}

	public synchronized String getDriver(Customer customer) {
		Driver driver = getBestDriver(customer);
		if (driver != null) {
			driverRepository.setDriverStatus(driver, true);
			updateDriverStatusResponseList(customer, driver.getDriverName());
			Order order = new Order();
			order.setOrderNumber(ThreadLocalRandom.current().nextInt());
			order.setCustomerName(customer.getCustomerName());
			order.setCustomerLatitude(customer.getCustomerLatitude());
			order.setCustomerLongitude(customer.getCustomerLongitude());
			orderRepository.addBookingOrder(order);
			return driver.getDriverName();
		}
		return null;
	}

	private void updateDriverStatusResponseList(Customer customer, String driverName) {
		DriverStatusResponse driverStatusResponseObj = driverStatusResponseList.stream()
				.filter(driverStatusResponse -> driverStatusResponse.getDriverName().equals(driverName)).findFirst()
				.get();
		driverStatusResponseObj.setCustomerName(customer.getCustomerName());
		driverStatusResponseObj.setStatus(true);
	}

	private Driver getBestDriver(Customer customer) {
		Driver bestDriver = null;
		double minDistance = Double.MAX_VALUE;

		for (Driver driver : driverRepository.getDrivers()) {
			if (!driver.isStatus()) {
				double distance = getDistance(customer.getCustomerLatitude(), driver.getCurrentLatitude(),
						customer.getCustomerLongitude(), driver.getCurrentLongitude(), 0.0, 0.0);
				if (distance < minDistance) {
					minDistance = distance;
					bestDriver = driver;
				}
			}
		}
		return bestDriver;
	}

	/**
	 * Calculate distance between two points in latitude and longitude taking
	 * into account height difference. If you are not interested in height
	 * difference pass 0.0. Uses Haversine method as its base. lat1, lon1 Start
	 * point; lat2, lon2 End point; el1 Start altitude in meters el2 End
	 * altitude in meters
	 * 
	 * @returns Distance in Meters
	 */
	private double getDistance(double lat1, double lat2, double lon1, double lon2, double el1, double el2) {

		final int R = 6371; // Radius of the earth

		double latDistance = Math.toRadians(lat2 - lat1);
		double lonDistance = Math.toRadians(lon2 - lon1);
		double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2) + Math.cos(Math.toRadians(lat1))
				* Math.cos(Math.toRadians(lat2)) * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
		double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
		double distance = R * c * 1000; // convert to meters

		double height = el1 - el2;

		distance = Math.pow(distance, 2) + Math.pow(height, 2);

		return Math.sqrt(distance);
	}

	public List<DriverStatusResponse> getDriverStatus() {
		return driverStatusResponseList;
	}

}
