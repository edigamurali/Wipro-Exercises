package com.wipro.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wipro.entity.CarRegistrationDetail;

public interface CarRegistrationDetailRepo extends JpaRepository<CarRegistrationDetail, Integer> {

}
