package com.wipro.service;

import java.util.List;

import com.wipro.entity.Order;

public interface OrderI {
	
	public void saveOrder(Order order);
	public List<Order> findAllOrders();

}
