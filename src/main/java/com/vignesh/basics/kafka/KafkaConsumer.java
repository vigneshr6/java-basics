package com.vignesh.basics.kafka;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(value = "app.kafka.enabled", havingValue = "true", matchIfMissing = true)
public class KafkaConsumer {

    @KafkaListener(topics = "test-topic", groupId = "sample-group")
    public void listen(String message) {
        System.out.println("Received Message: " + message);
    }
}
