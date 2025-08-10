package com.wipro.mockitodemo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test; 

class OrderServiceTest {

	@Test
	void OrderTest() 
	{
		OrderService orderService=mock(OrderService.class);
		when(orderService.placeOrder("ORD-01")).thenReturn("successful");
		String result=orderService.placeOrder("ORD-01");
		assertEquals(result,"successful");
	}

}
