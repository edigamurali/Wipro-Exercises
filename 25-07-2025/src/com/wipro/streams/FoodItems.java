package com.wipro.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FoodItems 
{
	String foodItemName;
	String foodCategory;
	Double price;
	
	
	
	public FoodItems(String foodItemName, String foodCategory, Double price) {
		super();
		this.foodItemName = foodItemName;
		this.foodCategory = foodCategory;
		this.price = price;
	}
	public String getFoodItemName() {
		return foodItemName;
	}
	public void setFoodItemName(String foodItemName) {
		this.foodItemName = foodItemName;
	}
	public String getFoodCategory() {
		return foodCategory;
	}
	public void setFoodCategory(String foodCategory) {
		this.foodCategory = foodCategory;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "FoodItems [foodItemName=" + foodItemName + ", foodCategory=" + foodCategory + ", price=" + price + "]";
	}
	
	public static void main(String[] args)
	{
		 	FoodItems fi = new FoodItems("Manchuria", "Chinese", 250.0);
		 	FoodItems fi1 = new FoodItems("Noodles", "Chinese", 250.0);
		 	FoodItems fi2=new FoodItems("Spring Rolls", "Chinese", 180.0);
	        FoodItems fi3 = new FoodItems("Pad Thai", "Thai", 300.0);
	        FoodItems fi4 = new FoodItems("Pasta ", "Continental", 350.0);
	        FoodItems fi5 = new FoodItems("Sushi", "Japanese", 500.0);
	        FoodItems fi6 = new FoodItems("Butter Chicken", "Indian", 400.0);
	        FoodItems fi7= new FoodItems("Fish Curry", "Indian", 400.0);
	        
	        List<FoodItems> list=new ArrayList();
	        list.add(fi1);
	        list.add(fi2);
	        list.add(fi3);
	        list.add(fi4);
	        list.add(fi5);
	        list.add(fi6);
	        list.add(fi7);
	        
	        List<FoodItems> outputList=list.stream()
	        		.filter(i->i.getFoodCategory().equals("Chinese"))
	        		.collect(Collectors.toList());
	        System.out.println(outputList);
	        
	        
	}
}
