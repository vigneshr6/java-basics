package com.vignesh.basics.kafka;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;

//@Configuration
public class KafkaConfiguration {
    public static final String CONSUMER_TOPIC = "test-topic";

    @Bean
    public NewTopic ordersTopic() {
        return new NewTopic(CONSUMER_TOPIC, 1, (short) 1);
    }
}
