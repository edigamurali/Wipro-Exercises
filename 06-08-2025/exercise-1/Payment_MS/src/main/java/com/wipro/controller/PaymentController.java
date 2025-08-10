package com.wipro.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.entity.Payment;
import com.wipro.service.PaymentService;

@RestController
@RequestMapping("/payment")
public class PaymentController {
	@Autowired
	PaymentService paymentService;

	@PostMapping
	public ResponseEntity<String> savePayment(@RequestBody Payment payment) {
	    HttpHeaders headers = new HttpHeaders();
	    headers.add("created-at", LocalDate.now().toString());
	    paymentService.savePayment(payment);
	    
	    return ResponseEntity
	            .status(200)
	            .headers(headers)
	            .body("Data Saved Successfully");
	}


	 @GetMapping
	 public ResponseEntity<?> findAllPayments() {
	        List<Payment> payments = paymentService.findPayment();
	        HttpHeaders headers = new HttpHeaders();
	        headers.add("search-time", LocalDateTime.now().toString());

	        if (payments.isEmpty()) {
	            return ResponseEntity.status(404)
	                    .headers(headers)
	                    .body("No payments found");
	        }

	        return ResponseEntity.ok()
	                .headers(headers)
	                .body(payments);
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity<?> findPaymentById(@PathVariable int id) {
	        Payment payment = paymentService.findById(id);
	        HttpHeaders headers = new HttpHeaders();
	        headers.add("search-time", LocalDateTime.now().toString());

	        if (payment == null) {
	            return ResponseEntity.status(404)
	                    .headers(headers)
	                    .body("Payment not found with ID: " + id);
	        }

	        return ResponseEntity.ok()
	                .headers(headers)
	                .body(payment);
	    }
	@PutMapping
	public ResponseEntity<String> updatePayment(@RequestBody Payment payment) 
	{
	    paymentService.updatePayment(payment);

	    HttpHeaders headers = new HttpHeaders();
	    headers.add("updated-at", LocalDate.now().toString());

	    return ResponseEntity
	            .status(200)
	            .headers(headers)
	            .body("Payment updated successfully");
	}

	@DeleteMapping
	public ResponseEntity<String> deletePayment(@RequestBody Payment payment)
	{
		paymentService.deletePayment(payment);
		HttpHeaders headers = new HttpHeaders();
	    headers.add("updated-at", LocalDate.now().toString());

	    return ResponseEntity
	            .status(200)
	            .headers(headers)
	            .body("Payment deleted successfully");
	}
}
