package com.wipro.service;

import java.util.List;

import com.wipro.entity.Payment;

public interface PaymentI {
	
	public void savePayment(Payment payment);
	public List<Payment> findPayment();
	public Payment updatePayment(Payment payment);
	public void deletePayment(Payment payment);
	public Payment findById(int id);

}
