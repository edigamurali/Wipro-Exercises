package com.wipro.test;

import com.wipro.oop.Restaurant;

public class RestaurantTesting {

	public static void main(String[] args) 
	{
		Restaurant restaurant=new Restaurant("RagamFoods",1000,"Hyderabad 500308",4.5f);
		System.out.println(restaurant);
		restaurant.setRating(4.0f);
		System.out.println(restaurant);
		Restaurant restaurant1=new Restaurant("SSSRestaurant",1001,"Chennai 500123",4.1f);
		System.out.println(restaurant1);

	}

}
