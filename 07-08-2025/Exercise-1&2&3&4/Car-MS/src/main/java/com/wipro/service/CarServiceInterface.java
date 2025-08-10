package com.wipro.service;

import java.util.List;

import com.wipro.entity.Car;

public interface CarServiceInterface 
{
	Car saveCar(Car car);
    List<Car> getAllCars();
    Car getCarById(int id);
    Car updateCar(int id,Car car);
    void deleteCar(int id);
}
