package com.wipro.order.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.order.entity.Order;
import com.wipro.order.service.OrderService;
import com.wipro.order.dto.OrderDetails;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/order")
@Tag(name = "Order Management", description = "APIs for order processing and management")
public class OrderController {
    private final OrderService service;
    
    public OrderController(OrderService service){ 
        this.service = service; 
    }
    @GetMapping("/{id}/items")
    @Operation(summary = "Get order details with items")
    public ResponseEntity<OrderDetails> getOrderWithItems(@PathVariable Long id){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        System.out.println("Get order details with items - User: " + auth.getName());
        return ResponseEntity.ok(service.getOrderWithItems(id));
    }

    @PostMapping
    @Operation(summary = "Create order from cart")
    public ResponseEntity<Order> create(@RequestParam Long userId){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        System.out.println("Create order - User: " + auth.getName() + " Authorities: " + auth.getAuthorities());
        return ResponseEntity.ok(service.createOrder(userId));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Cancel order")
    public ResponseEntity<Order> cancel(@PathVariable Long id){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        System.out.println("Cancel order - User: " + auth.getName());
        return ResponseEntity.ok(service.cancel(id));
    }

    @GetMapping
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @Operation(summary = "Get all orders (admin only)")
    public ResponseEntity<List<Order>> all(){ 
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        System.out.println("Get all orders - Admin: " + auth.getName());
        return ResponseEntity.ok(service.listAll()); 
    }

    @GetMapping("/user/{userId}")
    @Operation(summary = "Get orders by user")
    public ResponseEntity<List<Order>> byUser(@PathVariable Long userId){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        System.out.println("Get orders by user - User: " + auth.getName());
        return ResponseEntity.ok(service.listByUser(userId));
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get order details by ID")
    public ResponseEntity<Order> byId(@PathVariable Long id){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        System.out.println("Get order by ID - User: " + auth.getName());
        return ResponseEntity.ok(service.findById(id));
    }
}