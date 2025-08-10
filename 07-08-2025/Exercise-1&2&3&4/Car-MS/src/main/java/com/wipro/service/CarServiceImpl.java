package com.wipro.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.entity.Car;
import com.wipro.repo.CarRepo;

@Service
public class CarServiceImpl implements CarServiceInterface {

    @Autowired
    private CarRepo carRepo;

	@Override
	public Car saveCar(Car car) {
		
		return carRepo.save(car);
	}

	@Override
	public List<Car> getAllCars() {
		
		return carRepo.findAll();
	}

	@Override
	public Car getCarById(int id) {
		Optional<Car> opt=carRepo.findById(id);
		if(opt.isPresent())
		{
			return opt.get();
		}
		return null;
	}

	@Override
	public Car updateCar(int id, Car car) {
	    Optional<Car> opt = carRepo.findById(id);
	    if (opt.isPresent()) {
	        Car updateCar = opt.get();
	        updateCar.setMake(car.getMake());
	        updateCar.setCarRegistrationDetail(car.getCarRegistrationDetail());
	        return carRepo.save(updateCar);
	    }
	    return null;
	}


	@Override
	public void deleteCar(int id) 
	{
		carRepo.deleteById(id);
		
	}

    
}