package com.wipro.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.entity.Payment;
import com.wipro.repository.PaymentRepo;

@Service
public class PaymentService implements PaymentI {

	@Autowired
	 PaymentRepo paymentRepo;
	@Override
	public void savePayment(Payment payment) {
		
		paymentRepo.save(payment);
	}

	@Override
	public List<Payment> findPayment() {
		return paymentRepo.findAll();
	}

	@Override
	public void deletePayment(Payment payment) {
		 paymentRepo.delete(payment);
		
	}

	@Override
	public Payment updatePayment(Payment payment) {
		
		return  paymentRepo.save(payment);
	}

	@Override
	public Payment findById(int id) {
		Optional<Payment>opt=paymentRepo.findById(id);
		if(opt.isPresent())
		{
			return opt.get();
		}
		return null;
	}

}
