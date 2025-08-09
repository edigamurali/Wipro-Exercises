package com.wipro.oop;

public class Square extends Shape{
	
	double side;

	@Override
	public String toString() {
		return "Square [side=" + side + ", color=" + color + ", borderWidth=" + borderWidth + "]";
	}

	

	public Square(String color, float borderWidth,double side) {
		super(color, borderWidth);
		this.side=side;
	}



	public double getSide() {
		return side;
	}

	public void setSide(double side) {
		this.side = side;
	}
	

}
