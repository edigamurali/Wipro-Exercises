package com.wipro.service;

import java.util.List;

import com.wipro.entity.VehicleMovement;

public interface VehicleServiceI {

	public VehicleMovement save(VehicleMovement vehicleMovement);
	public List<VehicleMovement> findAll();
}
