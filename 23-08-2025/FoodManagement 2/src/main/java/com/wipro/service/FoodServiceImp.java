package com.wipro.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.entity.Food;
import com.wipro.repo.FoodRepo;

@Service
public class FoodServiceImp implements FoodService {

	@Autowired
	FoodRepo foodRepo;
	@Override
	public List<Food> showAllFood() {
		
		return foodRepo.findAll();
	}

	@Override
	public Food findFoodByID(int id) {
		Optional<Food> opt=foodRepo.findById(id);
		if(opt.isPresent()) {
			return opt.get();
		}
		return null;
	}

	@Override
	public Food saveFood(Food food) {
		
		return foodRepo.save(food);
	}

}
