package com.vignesh.basics.kafka;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

@RestController
@Slf4j
public class KafkaProducerController {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @GetMapping("/kafka/produce")
    public void sendMessage(@RequestParam String msg) {
        log.info("Producing message: {} to topic: {}", msg, KafkaConfiguration.CONSUMER_TOPIC);
        CompletableFuture<SendResult<String, String>> future = kafkaTemplate.send(KafkaConfiguration.CONSUMER_TOPIC, msg);
        future.whenComplete((result, ex) -> {
            if (ex == null) {
                log.info("Sent message=[" + msg +
                        "] with offset=[" + result.getRecordMetadata().offset() + "]");
            } else {
                log.error("Unable to send message=[" +
                        msg + "] due to : " + ex.getMessage());
            }
        });
    }

}
