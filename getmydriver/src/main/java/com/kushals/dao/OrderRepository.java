package com.kushals.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.kushals.model.Order;

@Repository
public class OrderRepository {
	private List<Order> ordersList = new ArrayList<>();

	public OrderRepository() {
	}

	public void addBookingOrder(Order order){
		this.ordersList.add(order);
	}
	
	public List<Order> getOrders(){
		return this.ordersList;
	}

}
