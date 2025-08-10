package com.wipro.entity;

import java.util.List;

import com.wipro.dto.Payment;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.Data;

@Entity
@Table(name = "orders")  
@Data
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column
    private String orderNumber;

    @Column
    private double orderValue;

    @Column
    private String orderStatus;
    
    @Transient
    private List<Payment> payment;
}
