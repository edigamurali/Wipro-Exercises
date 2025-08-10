package com.wipro.rider.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.wipro.rider.dto.BookingMessage;
import com.wipro.rider.util.AppConstant;

@Service
public class KafkaSenderService {

    @Autowired
    private KafkaTemplate<String, BookingMessage> kafkaTemplate;

    public void sendBookingRequest(BookingMessage msg) {
        kafkaTemplate.send(AppConstant.R2U_TOPIC, msg);
    }
}
