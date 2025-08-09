package com.wipro.test;


import com.wipro.oop.Circle;
import com.wipro.oop.Rectangle;
import com.wipro.oop.Square;

public class ShapeTesting {

	public static void main(String[] args) 
	{
		Circle circle=new Circle("red",1,10.0f);
		System.out.println(circle);
		Rectangle rectangle=new Rectangle("green",2.0f, 13.0, 10.0);
		System.out.println(rectangle);
		Square square=new Square("yellow",2.0f, 10.0);
		System.out.println(square);
	}

}
