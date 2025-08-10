package com.wipro.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.wipro.dto.Subject;

@Component
public class SpringConsumer {

	@KafkaListener(topics = "learn-subject", groupId = "group_id")
    public void consume(Subject msg) {
        System.out.println("Consumed message: " + msg);
    }

}
