package com.wipro.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wipro.entity.Car;

public interface CarRepo extends JpaRepository<Car, Integer>{

}
