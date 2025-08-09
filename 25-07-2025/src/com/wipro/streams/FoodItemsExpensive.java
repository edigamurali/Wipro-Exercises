package com.wipro.streams;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class FoodItemsExpensive 
{
	String foodItemName;
	String foodCategory;
	Double price;
	
	
	
	public FoodItemsExpensive(String foodItemName, String foodCategory, Double price) {
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
		 	FoodItemsExpensive fi = new FoodItemsExpensive("Manchuria", "Chinese", 250.0);
		 	FoodItemsExpensive fi1 = new FoodItemsExpensive("Noodles", "Chinese", 300.0);
		 	FoodItemsExpensive fi2=new FoodItemsExpensive("Spring Rolls", "Chinese", 180.0);
	        FoodItemsExpensive fi3 = new FoodItemsExpensive("Pad Thai", "Thai", 300.0);
	        FoodItemsExpensive fi4 = new FoodItemsExpensive("Pasta ", "Continental", 350.0);
	        FoodItemsExpensive fi5 = new FoodItemsExpensive("Sushi", "Japanese", 500.0);
	        FoodItemsExpensive fi6 = new FoodItemsExpensive("Butter Chicken", "Indian", 400.0);
	        FoodItemsExpensive fi7= new FoodItemsExpensive("Fish Curry", "Indian", 400.0);
	        
	        List<FoodItemsExpensive> list=new ArrayList();
	        list.add(fi1);
	        list.add(fi2);
	        list.add(fi3);
	        list.add(fi4);
	        list.add(fi5);
	        list.add(fi6);
	        list.add(fi7);
	        
	        Comparator<FoodItemsExpensive> comp= (f1,f2)->{
				Double i1= Double.valueOf(f1.price);
				Double i2= Double.valueOf(f2.price);
				return i1.compareTo(i2);
			};
	        
	        FoodItemsExpensive expensiveFood=
	        		list.stream()
	        		.filter(i->i.getFoodCategory().equals("Chinese"))
	        		.max(comp).orElse(null);
	        		
	        System.out.println(expensiveFood);
	        
	        
	}
}
