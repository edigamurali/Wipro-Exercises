package com.wipro.test;

import com.wipro.oop.Gpay;
import com.wipro.oop.PaymentMethod;
import com.wipro.oop.PhonePay;

public class PaymentMethodTesting {

	public static void main(String[] args) 
	{
		PaymentMethod payment=new Gpay();
		//PaymentMethod payment=new PhonePay();
		payment.pay(100000.0);

	}

}
