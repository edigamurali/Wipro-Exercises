package com.wipro.dto;

import java.util.List;

import lombok.Data;

@Data
public class Payment {
    private String paymentId;
    private String paymentMode;
    private double amount;
    private Boolean paymentStatus;
    private String orderNumber;
}
