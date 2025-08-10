package com.wipro.rider.listener;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.wipro.rider.dto.BookingMessage;
import com.wipro.rider.entity.Booking;
import com.wipro.rider.repo.BookingRepository;
import com.wipro.rider.util.AppConstant;

@Component
public class BookingMessageListener {

    @Autowired
    private BookingRepository bookingRepository;

    @KafkaListener(topics = AppConstant.U2R_TOPIC, groupId = "rider-group", containerFactory = "kafkaListenerContainerFactory")
    public void receiveRideConfirmation(BookingMessage message) {
        System.out.println("Rider MS received booking confirmation: " + message);

        Optional<Booking> bookingOpt = bookingRepository.findById(message.getBookingId());
        if (bookingOpt.isPresent()) {
            Booking booking = bookingOpt.get();
            booking.setPrice(message.getPrice());
            booking.setStatus(message.getStatus()); // should be "CONFIRMED"
            bookingRepository.save(booking);
            System.out.println("Booking status updated to CONFIRMED for bookingId: " + message.getBookingId());
        } else {
            System.out.println("Booking not found for id: " + message.getBookingId());
        }
    }
}
