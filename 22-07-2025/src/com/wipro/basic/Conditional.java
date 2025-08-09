package com.wipro.basic;

public class Conditional {

	public static void main(String[] args) {
		char shape='C';
		
		if(shape=='C')
		{
			System.out.println("circle");
		}
		else if(shape=='R')
		{
			System.out.println("rectangle");
		}
		else if(shape=='S')
		{
			System.out.println("square");
		}
		else
		{
			System.out.println("others");
		}
		switch(shape)
		{
		case 'C':
			System.out.println("circle");
			break;
		case 'R':
			System.out.println("rectangle");
			break;
		case 'S':
			System.out.println("square");
			break;
		default:
			System.out.println("others");
			break;
		}

	}

}
