package com.wipro.uber.listener;

import com.wipro.uber.dto.BookingMessage;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class BookingMessageListener {

    @KafkaListener(topics = "U2R", groupId = "rider-group", containerFactory = "kafkaListenerContainerFactory")
    public void listen(BookingMessage message) {
        System.out.println("Received BookingMessage:");
        System.out.println("Booking ID: " + message.getBookingId());
        System.out.println("Rider Name: " + message.getRiderName());
        System.out.println("Pickup Location: " + message.getPickup());
        System.out.println("Destination: " + message.getDestination());
        System.out.println("Status: " + message.getStatus());
        System.out.println("Vehicle Number: " + message.getVehicleNumber());
        System.out.println("OTP: " + message.getOtp());
        System.out.println("ETA: " + message.getEta());
        
    }
}
