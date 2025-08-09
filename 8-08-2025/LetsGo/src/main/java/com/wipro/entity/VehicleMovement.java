package com.wipro.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name ="vehicle_movement")
public class VehicleMovement {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	@Column
	int vehivleId;
	@Column
	double latitude;
	@Column
	double longitude;
}
