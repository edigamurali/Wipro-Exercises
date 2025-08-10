package com.wipro.uber.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.uber.entity.Ride;
import com.wipro.uber.repo.RideRepository;

@RestController
@RequestMapping("/rides")
public class RideController {

    private final RideRepository rideRepository;

    public RideController(RideRepository rideRepository) {
        this.rideRepository = rideRepository;
    }

    @GetMapping
    public List<Ride> getAllRides() {
        return rideRepository.findAll();
    }
}
