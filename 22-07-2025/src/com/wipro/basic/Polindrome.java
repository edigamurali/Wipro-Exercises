package com.wipro.basic;

public class Polindrome {

	public static void main(String[] args) 
	{
//		String name="racecar";
//		String polindrome="";
//		for(int i=0;i<name.length();i++)
//		{
//			polindrome=name.charAt(i)+polindrome;
//		}
//		if(name.equals(polindrome))
//		{
//			System.out.println("polindrome");
//		}
//		else
//		{
//			System.out.println("not polindrome");
//		}
//		System.out.println(polindrome);
	
	
	
		String name="racecar";
		StringBuilder sb=new StringBuilder(name);
		String name1=sb.reverse().toString();
		if(name.equals(name1))
		{
			System.out.println("polindrome");
		}
		else
		{
			System.out.println("not polindrome");
		}
		
	}

}
