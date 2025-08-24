package com.wipro.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wipro.entity.Food;
@Repository
public interface FoodRepo extends JpaRepository<Food, Integer> {

}
