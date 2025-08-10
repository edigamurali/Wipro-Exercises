package com.wipro.uber.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "ride")
public class Ride {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long bookingId;
    private String riderName;
    private Double price;
    private String pickup;
    private String destination;
    private String status; // e.g. RECEIVED, CONFIRMED
    private String vehicleNumber;
    private Integer otp;
    private String eta;
}
