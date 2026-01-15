package com.vignesh.basics.kafka;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(value = "app.kafka.enabled", havingValue = "true", matchIfMissing = true)
@Slf4j
public class KafkaConsumer {

    @KafkaListener(topics = KafkaConfiguration.CONSUMER_TOPIC, groupId = "sample-group")
    public void listen(String message) {
        log.info("Kafka Message Received: " + message);
    }
}
