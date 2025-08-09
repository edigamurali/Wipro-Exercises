package com.wipro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.entity.VehicleMovement;
import com.wipro.repo.VehicleRepo;

@Service
public class VehicleMovementServiceImp implements VehicleServiceI {

	@Autowired
	VehicleRepo vehicleRepo;
	@Override
	public VehicleMovement save(VehicleMovement vehicleMovement) {
		
		return vehicleRepo.save(vehicleMovement);
	}
	@Override
	public List<VehicleMovement> findAll() {
		
		return vehicleRepo.findAll();
	}

}
