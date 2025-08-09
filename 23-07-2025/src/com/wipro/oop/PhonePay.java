package com.wipro.oop;

public class PhonePay implements PaymentMethod {

	@Override
	public void pay(double amount) {
		System.out.println(amount+" Paying through PhonePay");

	}

}
