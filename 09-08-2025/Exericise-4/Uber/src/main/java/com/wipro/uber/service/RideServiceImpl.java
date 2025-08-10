package com.wipro.uber.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wipro.uber.dto.BookingMessage;
import com.wipro.uber.entity.Ride;
import com.wipro.uber.repo.RideRepository;
import com.wipro.uber.util.AppConstant;

@Service
public class RideServiceImpl implements RideService {

    @Autowired
    private RideRepository rideRepository;

    @Autowired
    private KafkaTemplate<String, BookingMessage> kafkaTemplate;

    @Transactional
    public void handleBookingMessage(BookingMessage msg) {
        Ride ride = new Ride();
        ride.setBookingId(msg.getBookingId());
        ride.setRiderName(msg.getRiderName());
        ride.setPickup(msg.getPickup());
        ride.setDestination(msg.getDestination());
        ride.setStatus("CONFIRMED");
        ride.setPrice(250.0);
        ride.setVehicleNumber("AP02V1234");
        ride.setOtp(1234);
        ride.setEta("20 min");

        rideRepository.save(ride);

        // Send confirmation back to Rider MS
        BookingMessage response = new BookingMessage();
        response.setBookingId(msg.getBookingId());
        response.setRiderName(msg.getRiderName());
        response.setPickup(msg.getPickup());
        response.setDestination(msg.getDestination());
        response.setPrice(250.0);
        response.setStatus("CONFIRMED");
        response.setVehicleNumber("AP02V1234");
        response.setOtp(1234);
        response.setEta("20 min");

        kafkaTemplate.send(AppConstant.U2R_TOPIC, response);
    }

    @KafkaListener(topics = AppConstant.R2U_TOPIC, groupId = "uber-group", containerFactory = "kafkaListenerContainerFactory")
    public void receiveBookingRequest(BookingMessage msg) {
        System.out.println("--- Uber MS received booking request: " + msg);
        handleBookingMessage(msg);
    }
}
