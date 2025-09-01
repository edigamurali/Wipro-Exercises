package com.wipro.order.dto;

import com.wipro.order.entity.Order;
import com.wipro.order.entity.OrderItem;
import lombok.Data;

import java.util.List;

@Data
public class OrderDetails {
    private Order order;
    private List<OrderItem> items;
    private Double totalAmount;
    
    public OrderDetails(Order order, List<OrderItem> items) {
        this.order = order;
        this.items = items;
        this.totalAmount = items.stream()
            .mapToDouble(item -> item.getPriceAtOrder() * item.getQuantity())
            .sum();
    }
    
    // Default constructor for JSON serialization
    public OrderDetails() {}
}