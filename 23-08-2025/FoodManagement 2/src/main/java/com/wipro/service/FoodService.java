package com.wipro.service;

import java.util.List;

import com.wipro.entity.Food;

public interface FoodService {
	List<Food> showAllFood();
	Food findFoodByID(int id);
	Food saveFood(Food food);
}
