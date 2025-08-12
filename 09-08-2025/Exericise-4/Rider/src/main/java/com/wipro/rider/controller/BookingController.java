package com.wipro.rider.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.rider.entity.Booking;
import com.wipro.rider.service.BookingService;

@RestController
@RequestMapping("/ride")
public class BookingController {

	@Autowired
    private BookingService bookingService;

   

    @PostMapping
    public ResponseEntity<Booking> bookRide(@RequestBody Booking booking) {
        Booking savedBooking = bookingService.createBooking(booking);
        return ResponseEntity.ok(savedBooking);
    }
}
