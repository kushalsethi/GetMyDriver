package com.kushals.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kushals.model.Customer;
import com.kushals.model.DriverStatusResponse;
import com.kushals.service.DriverPicker;

@CrossOrigin
@RestController
@RequestMapping("/main")
public class AppMainController {

	@Autowired
	private DriverPicker driverPicker;

	@RequestMapping(value = "/display", method = RequestMethod.GET)
	public String testMessage() {
		return "test";
	}

	@RequestMapping(value = "/getdriver", method = RequestMethod.GET)
	public ResponseEntity<String> getBestDriver(@RequestParam("userName") String userName,
			@RequestParam("userLatitude") double userLatitude, @RequestParam("userLongitude") double userLongitude) {
		Customer customer = new Customer(userName, userLatitude, userLongitude);
		String driverName = driverPicker.getDriver(customer);
		return new ResponseEntity<String>(driverName, HttpStatus.OK);
	}

	@RequestMapping(value = "/driverstatus", method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<List<DriverStatusResponse>> getDriversStatus() {
		List<DriverStatusResponse> response = driverPicker.getDriverStatus();
		return new ResponseEntity<List<DriverStatusResponse>>(response, HttpStatus.OK);
	}

}
