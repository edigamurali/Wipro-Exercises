package com.wipro.order.kafka;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderEvent {
    private Long productId;
    private Integer quantity;
    private String action; // "DECREASE" or "INCREASE"
}