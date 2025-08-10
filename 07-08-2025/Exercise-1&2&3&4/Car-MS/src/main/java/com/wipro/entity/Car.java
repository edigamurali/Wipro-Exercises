package com.wipro.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="car")
public class Car {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	@Column
	String make;
	@OneToOne(cascade = CascadeType.ALL,orphanRemoval = true)
	@JoinColumn(name="regDetailId",referencedColumnName = "id")
	CarRegistrationDetail carRegistrationDetail;

}
