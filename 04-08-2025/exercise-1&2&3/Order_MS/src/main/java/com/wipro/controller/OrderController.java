package com.wipro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.entity.Order;
import com.wipro.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;
   
    
    @PostMapping
    public ResponseEntity<String> saveOrderDetails(@RequestBody Order order) {
       
        orderService.saveOrder(order);
        return ResponseEntity.ok("Order processed with status: " + order.getOrderStatus());
    }
    @GetMapping
    public List<Order> findAllOrderDetails()
    {
    	
        List<Order> list = orderService.findAllOrders();
        return list;
    }

}
