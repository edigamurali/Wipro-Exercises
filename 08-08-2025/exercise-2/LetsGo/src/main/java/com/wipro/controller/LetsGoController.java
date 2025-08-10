package com.wipro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.entity.VehicleMovement;
import com.wipro.service.VehicleMovementServiceImp;

@RestController
@RequestMapping("/move")
public class LetsGoController {
	@Autowired
	VehicleMovementServiceImp vehicleMovementService;
	@PostMapping
	public ResponseEntity<VehicleMovement> saveVehicleMovement(@RequestBody VehicleMovement vehicalMovement)
	{
		return new ResponseEntity<VehicleMovement>(vehicleMovementService.save(vehicalMovement),HttpStatus.OK)  ;
	}
	@GetMapping
	public ResponseEntity<List<VehicleMovement>> findVehicleMovement()
	{
		return new ResponseEntity<List<VehicleMovement>>(vehicleMovementService.findAll(),HttpStatus.OK)  ;
	}
}
