package com.wipro.oop;

public class Restaurant {

	
	String restaurantName;
	int restaurantId;
	String address;
	float rating;
	
	
	public Restaurant()
	{
		
	}


	public Restaurant(String restaurantName, int restaurantId, String address, float rating) {
		super();
		this.restaurantName = restaurantName;
		this.restaurantId = restaurantId;
		this.address = address;
		this.rating = rating;
	}


	public String getRestaurantName() {
		return restaurantName;
	}


	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}


	public int getRestaurantId() {
		return restaurantId;
	}


	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public float getRating() {
		return rating;
	}


	public void setRating(float rating) {
		this.rating = rating;
	}


	@Override
	public String toString() {
		return "Restaurant [restaurantName=" + restaurantName + ", restaurantId=" + restaurantId + ", address="
				+ address + ", rating=" + rating + "]";
	}
	
	
}
