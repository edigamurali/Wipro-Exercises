package com.wipro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wipro.entity.Payment;

@Repository
public interface PaymentRepo extends JpaRepository<Payment, Integer> {

}
