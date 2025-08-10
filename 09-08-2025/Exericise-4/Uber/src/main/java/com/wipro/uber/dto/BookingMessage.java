package com.wipro.uber.dto;

import lombok.Data;

@Data
public class BookingMessage {
    private Long bookingId;
    private String riderName;
    private Double price;
    private String pickup;
    private String destination;
    private String status;
    private String vehicleNumber;
    private Integer otp;
    private String eta;
}
