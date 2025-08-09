package com.wipro.oop;

public class Circle extends Shape
{
	float radius;
	public Circle(String color, float borderWidth,float radius)
	{
		super(color, borderWidth);
		this.radius=radius;
	}

	

	
	public float getRadius() {
		return radius;
	}

	public void setRadius(float radius) {
		this.radius = radius;
	}

	@Override
	public String toString() {
		return "Circle [radius=" + radius + ", color=" + color + ", borderWidth=" + borderWidth + "]";
	}
	
}
