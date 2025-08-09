package com.wipro.basic;

import java.util.Arrays;

public class ShortestWord {

	public static void main(String[] args) 
	{
		String sentense="An anagram is a word or phrase formed by rearranging the letters of a different word or phrase";
		String arr[]=sentense.split(" ");
		System.out.println(Arrays.toString(arr));
		int lenWord[]=new int[arr.length];
		for(int i=0;i<arr.length;i++)
		{
			lenWord[i]=arr[i].length();
		}
	}		

}
