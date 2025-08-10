package com.wipro.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.wipro.dto.Payment;

@FeignClient(name = "payment-ms")
public interface PaymentConnectService {

	@PostMapping("/payment")
	ResponseEntity<String> savePayment(@RequestBody Payment payment);
	@GetMapping("/payment")
    ResponseEntity<Payment[]> findAllPayments();
}
