package com.wipro.order.service;

import com.wipro.order.dto.OrderDetails;
import com.wipro.order.entity.Order;
import com.wipro.order.entity.OrderItem;
import com.wipro.order.repo.CartItemRepo;
import com.wipro.order.repo.OrderItemRepo;
import com.wipro.order.repo.OrderRepo;
import com.wipro.order.kafka.OrderEvent;
import com.wipro.order.kafka.KafkaProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import jakarta.servlet.http.HttpServletRequest;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrderService {
    private final OrderRepo orderRepo;
    private final OrderItemRepo orderItemRepo;
    private final CartItemRepo cartItemRepo;
    private final KafkaProducerService producer;
    
    @Autowired
    private RestTemplate restTemplate;
    
    @Autowired
    private HttpServletRequest request;

    public OrderService(OrderRepo orderRepo, OrderItemRepo orderItemRepo, CartItemRepo cartItemRepo, KafkaProducerService producer) {
        this.orderRepo = orderRepo;
        this.orderItemRepo = orderItemRepo;
        this.cartItemRepo = cartItemRepo;
        this.producer = producer;
    }

    @Transactional
    public Order createOrder(Long userId){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        System.out.println("Creating order for userId: " + userId + " by user: " + auth.getName());
        
        var cart = cartItemRepo.findByUserId(userId);
        if (cart.isEmpty()) {
            throw new RuntimeException("Cart is empty for user " + userId);
        }

        // First, check stock availability for all items and fetch latest product details
        for (var ci : cart) {
            Product product = fetchProductDetails(ci.getProductId());
            if (product == null) {
                throw new RuntimeException("Product not found: " + ci.getProductId());
            }
            if (product.getStock() < ci.getQuantity()) {
                throw new RuntimeException("Insufficient stock for product " + product.getName() + 
                                         ". Available: " + product.getStock() + ", Required: " + ci.getQuantity());
            }
        }

        Order o = new Order();
        o.setUserId(userId);
        o.setStatus("CREATED");
        o.setCreatedAt(LocalDateTime.now());
        o = orderRepo.save(o);

        System.out.println("Order created with ID: " + o.getId() + " for user: " + userId);

        // Process each cart item
        for (var ci : cart){
            try {
                // Fetch latest product details for current price
                Product product = fetchProductDetails(ci.getProductId());
                if (product == null) {
                    throw new RuntimeException("Product not found: " + ci.getProductId());
                }

                // Try direct HTTP call first, fallback to Kafka
                boolean stockUpdated = updateProductStockDirect(ci.getProductId(), -ci.getQuantity());
                
                if (!stockUpdated) {
                    // Fallback to Kafka
                    producer.send(new OrderEvent(ci.getProductId(), ci.getQuantity(), "DECREASE"));
                    System.out.println("Sent Kafka event to decrease stock for product: " + ci.getProductId());
                }

                OrderItem oi = new OrderItem();
                oi.setOrderId(o.getId());
                oi.setProductId(ci.getProductId());
                oi.setQuantity(ci.getQuantity());
                oi.setPriceAtOrder(product.getPrice()); // Set current price from product service
                oi.setProductName(product.getName());
                oi.setProductImage(product.getImage());
                orderItemRepo.save(oi);
                
                System.out.println("Created order item for product: " + product.getName() + 
                                 " with price: " + product.getPrice() + " and quantity: " + ci.getQuantity());
                
            } catch (Exception e) {
                System.out.println("Error processing cart item: " + ci.getId() + " - " + e.getMessage());
                // Rollback: cancel the order
                o.setStatus("FAILED");
                orderRepo.save(o);
                throw new RuntimeException("Failed to process order item for product " + ci.getProductId() + ": " + e.getMessage());
            }
        }
        
        cartItemRepo.deleteAll(cart);
        System.out.println("Cart cleared for user: " + userId);
        return o;
    }

    private Product fetchProductDetails(Long productId) {
        try {
            String authHeader = request.getHeader("Authorization");
            HttpHeaders headers = new HttpHeaders();
            if (authHeader != null) {
                headers.set("Authorization", authHeader);
            }
            
            HttpEntity<String> entity = new HttpEntity<>(headers);
            ResponseEntity<Product> response = restTemplate.exchange(
                "http://localhost:9001/products/" + productId,
                HttpMethod.GET,
                entity,
                Product.class
            );
            
            return response.getBody();
        } catch (Exception e) {
            System.out.println("Error fetching product details for productId " + productId + ": " + e.getMessage());
            return null;
        }
    }

    private boolean checkProductStock(Long productId, Integer requiredQty) {
        try {
            Product product = fetchProductDetails(productId);
            return product != null && product.getStock() >= requiredQty;
        } catch (Exception e) {
            System.out.println("Error checking stock for product " + productId + ": " + e.getMessage());
            return false;
        }
    }

    private boolean updateProductStockDirect(Long productId, Integer delta) {
        try {
            String authHeader = request.getHeader("Authorization");
            HttpHeaders headers = new HttpHeaders();
            if (authHeader != null) {
                headers.set("Authorization", authHeader);
            }
            
            HttpEntity<String> entity = new HttpEntity<>(headers);
            ResponseEntity<Product> response = restTemplate.exchange(
                "http://localhost:9001/products/stock/" + productId + "?delta=" + delta,
                HttpMethod.PUT,
                entity,
                Product.class
            );
            
            return response.getStatusCode().is2xxSuccessful();
        } catch (Exception e) {
            System.out.println("Direct stock update failed for product " + productId + ": " + e.getMessage());
            return false;
        }
    }

    public List<Order> listAll(){ 
        return orderRepo.findAll(); 
    }
    
    public List<Order> listByUser(Long userId){ 
        return orderRepo.findByUserId(userId); 
    }
    
    public Order findById(Long id){ 
        return orderRepo.findById(id).orElseThrow(() -> new RuntimeException("Order not found with id: " + id)); 
    }

    @Transactional
    public Order cancel(Long orderId){
        Order o = findById(orderId);
        if ("CANCELLED".equals(o.getStatus())) {
            return o;
        }

        var items = orderItemRepo.findByOrderId(orderId);
        for (var oi : items) {
            try {
                // Try direct HTTP call first
                boolean stockUpdated = updateProductStockDirect(oi.getProductId(), oi.getQuantity());
                
                if (!stockUpdated) {
                    // Fallback to Kafka
                    producer.send(new OrderEvent(oi.getProductId(), oi.getQuantity(), "INCREASE"));
                }
                
                System.out.println("Restored stock for product: " + oi.getProductName() + 
                                 " quantity: " + oi.getQuantity());
            } catch (Exception e) {
                System.out.println("Error restoring stock for product: " + oi.getProductId() + " - " + e.getMessage());
            }
        }

        o.setStatus("CANCELLED");
        return orderRepo.save(o);
    }
    public OrderDetails getOrderWithItems(Long orderId) {
        Order order = findById(orderId);
        List<OrderItem> items = orderItemRepo.findByOrderId(orderId);
        return new OrderDetails(order, items);
    }
    // Inner class for Product response
    @Data
    public static class Product {
        private Long id;
        private String name;
        private String description;
        private Double price;
        private Integer stock;
        private String category;
        private String image;
        
       
    }
}