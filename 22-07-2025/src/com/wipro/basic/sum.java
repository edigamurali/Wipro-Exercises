package com.wipro.basic;

import java.util.Arrays;

public class sum {

	public static void main(String[] args) 
	{
		/*
		 * int num[] = {2, 7, 11, 15}; int target = 9;
		 * 
		 * for (int i = 0; i < num.length; i++) { for (int j =i+1; j < num.length; j++)
		 * { if (num[i] + num[j] == target) { System.out.println(i + "  " + j ); } } }
		 * System.out.println(Arrays.toString(num));
		 */
		int[] arr= {2, 7, 11, 15};
	    int target=9;
	    int[] output= {0,0};
	    
		for(int i=0;i<arr.length;i++)
		{
			if(((i+1)<arr.length)&&(arr[i]+arr[i+1]==target))
			{
				
				output[0]=i;
				output[1]=i+1;
			}
			
		}
	
		System.out.println(output[0]+" "+output[1]);
		 
	}

}
