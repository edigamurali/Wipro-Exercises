package com.wipro.basic;

public class Rounding {

	public static void main(String[] args) 
	{
		float num1=25.1231f;
		float num2=25.1273f;
		float roundNum1=Math.round(num1*1000);
		float roundNum2=Math.round(num2*1000);
		if(roundNum1==roundNum2)
		{
			System.out.println("They are same");
		}
		else {
			System.out.println("They are diffirent");
		}

	}

}
