package com.wipro.order.kafka;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class KafkaProducerService {
    private final KafkaTemplate<String, Object> template;

    public KafkaProducerService(KafkaTemplate<String, Object> template) {
        this.template = template;
    }

    public void send(OrderEvent event) {
        try {
            System.out.println("Sending Kafka event: " + event);
            CompletableFuture<SendResult<String, Object>> future = template.send("order-topic", event);
            
            future.whenComplete((result, ex) -> {
                if (ex == null) {
                    System.out.println("Kafka message sent successfully: " + event + 
                                     " with offset: " + result.getRecordMetadata().offset());
                } else {
                    System.out.println("Failed to send Kafka message: " + ex.getMessage());
                }
            });
        } catch (Exception e) {
            System.out.println("Error sending Kafka message: " + e.getMessage());
            throw new RuntimeException("Failed to send order event", e);
        }
    }
}