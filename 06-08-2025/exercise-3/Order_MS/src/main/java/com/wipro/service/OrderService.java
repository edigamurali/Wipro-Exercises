package com.wipro.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.wipro.dto.Payment;
import com.wipro.entity.Order;
import com.wipro.repo.OrderRepo;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
public class OrderService implements OrderI {

	
	 @Autowired
	 OrderRepo orderRepo;
	 @Autowired
	 private RestTemplate restTemplate;
	 @Autowired
	 private PaymentConnectService paymentConnectService;
	
	@Override
	@CircuitBreaker(name="order-cb" , fallbackMethod="handleFallBack")
	public void saveOrder(Order order)
 
	{
		 	order.setOrderStatus("I"); 
	        orderRepo.save(order);
	  
	            Payment payment = new Payment();
	            payment.setOrderNumber(order.getOrderNumber());
	            payment.setPaymentId("PAY12345");
	            payment.setPaymentMode("CARD");
	            payment.setAmount(order.getOrderValue());
	            payment.setPaymentStatus(true);
	            String paymentUrl = "http://payment-ms/payment";

	            //ResponseEntity<String> response = restTemplate.postForEntity(paymentUrl, payment, String.class);
	            ResponseEntity<String> response=paymentConnectService.savePayment(payment);
	            //System.out.println(response.getStatusCode());
	            if (response.getStatusCode() == HttpStatus.OK) {
	                order.setOrderStatus("P"); 
	            } else {
	                order.setOrderStatus("C"); 
	            }

	        orderRepo.save(order);
	}

	@Override
	public List<Order> findAllOrders() 
	{
		List<Order>list=orderRepo.findAll();

        try {
        	String url = "http://payment-ms/payment";
        	//ResponseEntity<Payment[]> response = restTemplate.getForEntity(url, Payment[].class);
        	ResponseEntity<Payment[]> response =paymentConnectService.findAllPayments();
            if (response.getStatusCode() == HttpStatusCode.valueOf(200)) {
                List<Payment> payments = Arrays.asList(response.getBody());

                for (Order order : list) {
                    List<Payment> payment = payments.stream()
                            .filter(p -> p.getOrderNumber().equals(order.getOrderNumber()))
                            .collect(Collectors.toList());
                    order.setPayment(payment); 
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
		
		return list;
	}

	void handleFallBack(Order order,Throwable t)
	{
		System.out.println("--System is down--");
		
	}

}
