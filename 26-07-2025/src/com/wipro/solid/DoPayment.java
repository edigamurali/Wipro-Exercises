package com.wipro.solid;

import java.util.Scanner;

public class DoPayment {

	public static void main(String[] args) 
	{
		System.out.println("1:PhonePay\t2:GPay\t3:Paytym");
		System.out.println("Enter paymentType Type number ");
		Scanner sc=new Scanner(System.in);
		int paymentType=sc.nextInt();
		DigitalPayment dp=null;
		if(paymentType==1)
		{
			dp=new PhonePay();
		}
		else if(paymentType==2)
		{
			dp=new GPay();
		}
		else if(paymentType==3)
		{
			dp=new Paytym();
		}
		else {
			System.out.println("please select correct type to pay");
		}
		dp.pay();

	}

}
