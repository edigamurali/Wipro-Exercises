package com.wipro.dto;

import java.time.LocalDateTime;
import lombok.Data;

@Data
public class OrderResponse {
    private Long id;
    private String productName;
    private Integer qty;
    private LocalDateTime orderDate;
}
