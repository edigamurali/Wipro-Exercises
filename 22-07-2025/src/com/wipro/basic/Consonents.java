package com.wipro.basic;

public class Consonents {

	public static void main(String[] args) {
		char vowels[]= {'a','e','i','o','u'};
		int vowelsCount=0;
		String name="edigamurali";
		for(int i=0;i<name.length();i++)
		{
			for(int j=0;j<vowels.length;j++)
			{
				if(name.charAt(i)==vowels[j])
				{
					vowelsCount++;
				}
			}
		}
		System.out.println("vowels count ="+vowelsCount);
		System.out.println("consonents count ="+(name.length()-vowelsCount));
	}

}
