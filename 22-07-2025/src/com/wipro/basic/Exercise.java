package com.wipro.basic;

public class Exercise {

	public static void main(String[] args) 
	{
		float number=-0.20f;
		float absolute=Math.abs(number);
		if(number==0 )
		{
			System.out.println("zero");
		}
		else if(number>0 )
		{
			System.out.println("positive");
		}
		else {
			System.out.println("negative");
		}
		if (absolute < 1) {
            System.out.println("small");
        }
		if (absolute> 1000000) {
            System.out.println("large");
        } 
	}

}
