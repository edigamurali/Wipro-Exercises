package com.wipro.oop;

public class Rectangle extends Shape {

	double length;
	double breadth;
	public double getLength() {
		return length;
	}
	public void setLength(double length) {
		this.length = length;
	}
	public double getBreadth() {
		return breadth;
	}
	public void setBreadth(double breadth) {
		this.breadth = breadth;
	}
	
	public Rectangle(String color, float borderWidth,double length,double breadth) {
		super(color, borderWidth);
		this.length=length;
		this.breadth=breadth;
	}
	@Override
	public String toString() {
		return "Rectangle [length=" + length + ", breadth=" + breadth + ", color=" + color + ", borderWidth="
				+ borderWidth + "]";
	}
	
	
}
