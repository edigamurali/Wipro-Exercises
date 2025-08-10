package com.wipro.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wipro.entity.VehicleMovement;

@Repository
public interface VehicleRepo extends JpaRepository<VehicleMovement, Integer> {

}
