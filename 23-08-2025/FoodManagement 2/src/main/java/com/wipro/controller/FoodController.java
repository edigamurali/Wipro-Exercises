package com.wipro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.entity.Food;
import com.wipro.service.FoodServiceImp;

@RestController
@RequestMapping("/food")
@CrossOrigin(origins = "http://localhost:4200")
public class FoodController {
	@Autowired
	FoodServiceImp foodService;
	
	@PostMapping
	public ResponseEntity<Food> saveFood(@RequestBody() Food food)
	{
		return new ResponseEntity<Food>(foodService.saveFood(food), HttpStatus.OK);
	}
	@GetMapping
	public ResponseEntity<List<Food>> findFood()
	{
		return new ResponseEntity<List<Food>>(foodService.showAllFood(), HttpStatus.OK);
	}
}
