package com.wipro.uber.service;

import com.wipro.uber.dto.BookingMessage;

public interface RideService {
    void handleBookingMessage(BookingMessage msg);
}
