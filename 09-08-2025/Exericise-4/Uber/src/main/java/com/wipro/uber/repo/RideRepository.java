package com.wipro.uber.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wipro.uber.entity.Ride;

public interface RideRepository extends JpaRepository<Ride, Long> {
    Optional<Ride> findByBookingId(Long bookingId);
}
