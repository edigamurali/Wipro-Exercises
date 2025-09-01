package com.wipro.product.kafka;

import com.wipro.product.entity.Product;
import com.wipro.product.repo.ProductRepo;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {
    private final ProductRepo repo;

    public KafkaConsumerService(ProductRepo repo){ this.repo = repo; }

    @KafkaListener(topics = "order-topic", groupId = "order-group", containerFactory = "kafkaListenerContainerFactory")
    public void consume(OrderEvent event){
        Product p = repo.findById(event.getProductId())
                        .orElseThrow(() -> new RuntimeException("Product not found"));

        if ("DECREASE".equals(event.getAction())) {
            if (p.getStock() < event.getQuantity())
                throw new RuntimeException("Stock not available");
            p.setStock(p.getStock() - event.getQuantity());
        } else if ("INCREASE".equals(event.getAction())) {
            p.setStock(p.getStock() + event.getQuantity());
        }
        repo.save(p);
    }
}
