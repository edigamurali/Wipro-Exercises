package com.wipro.product.kafka;

import com.wipro.product.entity.Product;
import com.wipro.product.repo.ProductRepo;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class KafkaConsumerService {
    private final ProductRepo repo;

    public KafkaConsumerService(ProductRepo repo) { 
        this.repo = repo; 
    }

    @KafkaListener(topics = "order-topic", groupId = "order-group", containerFactory = "kafkaListenerContainerFactory")
    @Transactional
    public void consume(OrderEvent event) {
        try {
            System.out.println("Received Kafka event: " + event);
            
            Product p = repo.findById(event.getProductId())
                            .orElseThrow(() -> new RuntimeException("Product not found with id: " + event.getProductId()));

            if ("DECREASE".equals(event.getAction())) {
                if (p.getStock() < event.getQuantity()) {
                    throw new RuntimeException("Insufficient stock for product " + event.getProductId() + 
                                             ". Available: " + p.getStock() + ", Required: " + event.getQuantity());
                }
                p.setStock(p.getStock() - event.getQuantity());
                System.out.println("Decreased stock for product " + event.getProductId() + " by " + event.getQuantity());
            } else if ("INCREASE".equals(event.getAction())) {
                p.setStock(p.getStock() + event.getQuantity());
                System.out.println("Increased stock for product " + event.getProductId() + " by " + event.getQuantity());
            }
            
            repo.save(p);
            System.out.println("Stock updated successfully for product " + event.getProductId() + ". New stock: " + p.getStock());
            
        } catch (Exception e) {
            System.out.println("Error processing Kafka event: " + e.getMessage());
            throw e; // Re-throw to trigger Kafka retry mechanism
        }
    }
}