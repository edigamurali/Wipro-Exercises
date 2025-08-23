package com.wipro.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.wipro.dto.OrderRequest;
import com.wipro.dto.OrderResponse;
import com.wipro.service.OrderService;

@RestController
@RequestMapping("/orders")
@CrossOrigin(origins = "http://localhost:4200")
public class OrderController {

    @Autowired private OrderService orderService;

    @PostMapping public OrderResponse placeOrder(@RequestBody OrderRequest req) { return orderService.placeOrder(req); }

    @GetMapping public List<OrderResponse> getAllOrders() { return orderService.getAllOrders(); }
}
