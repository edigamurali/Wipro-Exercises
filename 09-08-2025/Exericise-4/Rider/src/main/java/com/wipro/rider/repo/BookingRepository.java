package com.wipro.rider.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.wipro.rider.entity.Booking;

public interface BookingRepository extends JpaRepository<Booking, Long> {
}
