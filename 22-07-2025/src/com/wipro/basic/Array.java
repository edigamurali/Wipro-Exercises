package com.wipro.basic;

public class Array {

	public static void main(String[] args)
	{
		int num[]=new int[5];
		num[0]=10;
		num[1]=20;
		num[2]=50;
		num[3]=100;
		num[4]=70;
		for(int i=0;i<num.length;i++)
		{
			num[i]=num[i]*2;
		}
		for(int j:num)
		{
			System.out.println(j);
		}

	}

}
