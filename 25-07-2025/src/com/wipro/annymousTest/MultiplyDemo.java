package com.wipro.annymousTest;

import com.wipro.anonymous.Multiply;

public class MultiplyDemo {

	public static void main(String[] args) 
	{
		Multiply multiply=(a,b)->{return a*b ;};
		int result=multiply.multiply(10,20);
		System.out.println(result);
	}

}
