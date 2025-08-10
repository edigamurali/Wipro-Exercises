package com.wipro.rider.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.rider.dto.BookingMessage;
import com.wipro.rider.entity.Booking;
import com.wipro.rider.repo.BookingRepository;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private KafkaSenderService kafkaSender;

    public Booking createBooking(Booking booking) {
        booking.setStatus("PENDING");
        Booking saved = bookingRepository.save(booking);

        BookingMessage msg = new BookingMessage();
        msg.setBookingId(saved.getId());
        msg.setRiderName(saved.getRiderName());
        msg.setPickup(saved.getPickup());
        msg.setDestination(saved.getDestination());
        msg.setStatus(saved.getStatus());
        msg.setPrice(250.0);
        kafkaSender.sendBookingRequest(msg);
        return saved;
    }

    public void updateBookingStatus(Long bookingId, String status) {
        bookingRepository.findById(bookingId).ifPresent(b -> {
            b.setStatus(status);
            bookingRepository.save(b);
        });
    }
}
